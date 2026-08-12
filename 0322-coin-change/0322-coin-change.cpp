class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();

        vector<vector<int>> dp(n,vector<int> (amount+1,0));

        for(int t = 0; t<=amount; t++)
        {
            if(t % coins[0] == 0) dp[0][t] = t/coins[0];
            else dp[0][t] = 1e9;
        }

        for(int indx = 1; indx<n; indx++)
        {
            for(int t = 0; t<=amount;t++)
            {
                int nottake = 0 + dp[indx-1][t];
                int take = INT_MAX;
                if(coins[indx] <= t)
                {
                take = 1 + dp[indx][t - coins[indx]];
                }
              dp[indx][t] = min(take,nottake);
            }
        }

        int ans = dp[n-1][amount];
        if(ans>= 1e9)
        return -1;
        return ans;
        
    }
};