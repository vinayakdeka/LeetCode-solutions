class Solution {

    public int firstStableIndex(int[] nums, int k) {

        int n = nums.length;

        // suffixMin[i] = minimum element from i to n-1
        int[] suffixMin = new int[n];

        suffixMin[n - 1] = nums[n - 1];

        // Build suffix minimum array
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        // Maintain prefix maximum
        int leftMax = 0;

        for (int i = 0; i < n; i++) {

            leftMax = Math.max(leftMax, nums[i]);

            int instability = leftMax - suffixMin[i];

            if (instability <= k) {
                return i;
            }
        }

        return -1;
    }
}