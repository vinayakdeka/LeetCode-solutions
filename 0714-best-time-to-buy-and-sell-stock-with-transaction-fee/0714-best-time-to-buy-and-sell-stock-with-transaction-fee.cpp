class Solution {
public:

    int f(int indx, int buy, vector<int>& prices,
          int n, int fee, vector<vector<int>>& dp)
    {
        if(indx == n)
            return 0;

        if(dp[indx][buy] != -1)
            return dp[indx][buy];

        if(buy)
        {
            return dp[indx][buy] =
                max(-prices[indx] + f(indx+1,0,prices,n,fee,dp),
                     f(indx+1,1,prices,n,fee,dp));
        }
        else
        {
            return dp[indx][buy] =
                max(prices[indx] - fee + f(indx+1,1,prices,n,fee,dp),
                     f(indx+1,0,prices,n,fee,dp));
        }
    }

    int maxProfit(vector<int>& prices, int fee)
    {
        int n = prices.size();

        vector<vector<int>> dp(n, vector<int>(2,-1));

        return f(0,1,prices,n,fee,dp);
    }
};