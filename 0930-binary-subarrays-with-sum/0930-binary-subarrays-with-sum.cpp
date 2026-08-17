class Solution {
public:
    int atMostgoal(vector<int>& nums, int goal) {
        if (goal < 0) return 0;

        int left = 0;
        int sum = 0;
        int count = 0;

        // Traverse the array using right pointer
        for (int right = 0; right < nums.size(); right++) {
            // Add current element to sum
            sum += nums[right];

            // Shrink the window from the left if sum exceeds k
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }

            // Add the number of valid subarrays ending at right
            count += (right - left + 1);
        }

        return count;
    }

        int numSubarraysWithSum(vector<int>& nums, int goal)
        {
            return atMostgoal(nums,goal) - atMostgoal(nums,goal-1);
        }
    
};