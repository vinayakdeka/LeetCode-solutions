class Solution {
public:
    int maxCoins(vector<int>& nums) {

        nums.push_back(1);
        nums.insert(nums.begin(), 1);

        int n = nums.size();

        vector<vector<long long>> dp(
            n, vector<long long>(n, 0)
        );

        for(int i = n - 2; i >= 1; i--)
        {
            for(int j = i; j <= n - 2; j++)
            {
                long long maxcoin = 0;

                for(int index = i; index <= j; index++)
                {
                    long long coin =
                        1LL * nums[i-1]
                        * nums[index]
                        * nums[j+1]
                        + dp[i][index-1]
                        + dp[index+1][j];

                    maxcoin = max(maxcoin, coin);
                }

                dp[i][j] = maxcoin;
            }
        }

        return dp[1][n-2];
    }
};