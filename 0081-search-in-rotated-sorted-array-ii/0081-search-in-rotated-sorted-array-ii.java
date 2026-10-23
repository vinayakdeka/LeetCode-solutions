
class Solution {
    public boolean search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Target found
            if (nums[mid] == target) {
                return true;
            }

            // Duplicates make the sorted half ambiguous
            if (nums[low] == nums[mid] &&
                nums[mid] == nums[high]) {
                low++;
                high--;
            }

            // Left half is sorted
            else if (nums[low] <= nums[mid]) {

                if (target >= nums[low] &&
                    target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // Right half is sorted
            else {

                if (target > nums[mid] &&
                    target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}
