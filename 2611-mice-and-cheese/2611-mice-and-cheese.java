class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int[] diff = new int[n];
        int ans = 0;

        for(int i=0; i<n; i++){
            ans += reward2[i];
            diff[i] = reward1[i] - reward2[i];
        }

        Arrays.sort(diff);

        for(int i=n-1; i>=n-k; i--){
            ans += diff[i];
        }

        return ans;
    }
}