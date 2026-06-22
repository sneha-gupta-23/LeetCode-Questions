class Solution {
    public int findKthPositive(int[] arr, int k) {
        int high = 0;
        int low = arr.length - 1;

        while(high <= low){
            int mid = high + (low - high) / 2;

            int missingNum = arr[mid] - (mid + 1);
            
            if(missingNum < k){
                high = mid + 1;
            }
            else{
                low = mid - 1;
            }
        }

        return k + high;
    }
}