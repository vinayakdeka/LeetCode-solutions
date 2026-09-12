class Solution {
public:
    void nextPermutation(vector<int>& nums) {

        int n = nums.size();
        int i = n - 2;

        // Step 1: Find the first decreasing element from right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If pivot exists
        if (i >= 0) {

            // Find the smallest element greater than nums[i]
            int j = n - 1;

            while (nums[j] <= nums[i]) {
                j--;
            }

            // Step 3: Swap pivot and successor
            swap(nums[i], nums[j]);
        }

        // Step 4: Reverse the suffix
        reverse(nums.begin() + i + 1, nums.end());
    }
};