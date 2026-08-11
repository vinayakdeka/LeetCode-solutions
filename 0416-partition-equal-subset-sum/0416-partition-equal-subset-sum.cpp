class Solution {
public:

    bool isSubsetSum(vector<int> arr, int target)
    {
        int n = arr.size();

        vector<vector<int>> dp(n, vector<int>(target + 1, 0));

        // Target = 0 is always possible
        for(int i = 0; i < n; i++)
        {
            dp[i][0] = 1;
        }

        // First element
        if(arr[0] <= target)
        {
            dp[0][arr[0]] = 1;
        }

        // Fill the DP table
        for(int i = 1; i < n; i++)
        {
            for(int k = 1; k <= target; k++)
            {
                // Don't take current element
                bool nottake = dp[i - 1][k];

                // Take current element
                bool take = false;

                if(arr[i] <= k)
                {
                    take = dp[i - 1][k - arr[i]];
                }

                dp[i][k] = take || nottake;
            }
        }

        return dp[n - 1][target];
    }

    bool canPartition(vector<int>& nums)
    {
        int n = nums.size();

        int totalSum = 0;

        for(int i = 0; i < n; i++)
        {
            totalSum += nums[i];
        }

        // Odd sum cannot be divided into two equal subsets
        if(totalSum % 2 != 0)
            return false;

        int target = totalSum / 2;

        return isSubsetSum(nums, target);
    }
};