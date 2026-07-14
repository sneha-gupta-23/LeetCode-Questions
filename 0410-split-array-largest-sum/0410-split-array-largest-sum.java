class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        // Find search range
        for (int num : nums) {
            low = Math.max(low, num); // Largest element
            high += num;              // Total sum
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                high = mid;       // Try smaller answer
            } else {
                low = mid + 1;    // Need larger answer
            }
        }

        return low;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {
        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                subarrays++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }

        return subarrays <= k;
    }
}