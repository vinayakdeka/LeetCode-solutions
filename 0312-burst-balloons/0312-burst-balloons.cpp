class Solution {
public:

    int f(int i, int j,vector<int>& nums, vector<vector<long long>> &dp)
    {
        if(i>j) return 0;
        long long maxcoin = 0;
        if(dp[i][j]!=-1) return dp[i][j];

        for(int index = i; index<=j;index++)
        {
           long long coin =
                1LL * nums[i-1] * nums[index] * nums[j+1]
                + f(i, index-1, nums, dp)
                + f(index+1, j, nums, dp);

            maxcoin = max(maxcoin, coin);
        }
         return dp[i][j] = maxcoin;
    }
    int maxCoins(vector<int>& nums) {
        nums.push_back(1);
        nums.insert(nums.begin(),1);
        int n = nums.size();
        vector<vector<long long>> dp(n+1,vector<long long> (n+1,-1));
        return f(1,n-2,nums,dp);  
    }
};