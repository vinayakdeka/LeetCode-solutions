
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = -1, right = -1;

        // First pass: find the right boundary
        int max = nums[0];

        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);

            if (nums[i] < max) {
                right = i;
            }
        }

        // Second pass: find the left boundary
        int min = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            min = Math.min(min, nums[i]);

            if (nums[i] > min) {
                left = i;
            }
        }

        // Array is already sorted
        if (left == -1) {
            return 0;
        }

        return right - left + 1;
    }
}
