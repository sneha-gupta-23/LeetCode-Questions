class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            ans[i] = -1;
            for(int j=1; j<nums.length; j++){
                int k = (i+j) % nums.length;
                if(nums[k] > nums[i]){
                    ans[i] = nums[k];
                    break;
                }
            }
        }
        return ans;
    }
}