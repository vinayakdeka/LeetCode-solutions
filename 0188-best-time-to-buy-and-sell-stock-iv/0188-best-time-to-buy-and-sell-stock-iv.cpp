class Solution {
public:
    int f(int indx,int transNo, vector<int>& prices,int n, int k, vector<vector<int>> &dp )
    {
        if(indx == n || transNo == 2*k) return 0;

        if(dp[indx][transNo] != -1) return dp[indx][transNo];

        long long profit = 0;

        if(transNo%2 == 0) // buy
        {
          profit = max(-prices[indx] + f(indx+1,transNo+1,prices,n,k,dp) , 0 + f(indx+1,transNo,prices,n,k,dp));
        }
        else
        {
            profit = max(prices[indx] + f(indx+1,transNo+1,prices,n,k,dp) , 0 + f(indx+1,transNo,prices,n,k,dp));
        }
        return dp[indx][transNo] = profit;
    }

    int maxProfit(int k, vector<int>& prices) {

        int n = prices.size();

        vector<vector<int>> dp(n + 1, vector<int>(2 * k + 1, 0));

        for (int indx = n - 1; indx >= 0; indx--)
        {
            for (int transNo = 2 * k - 1; transNo >= 0; transNo--)
            {
                if (transNo % 2 == 0)   // Buy
                {
                    dp[indx][transNo] = max(
                        -prices[indx] + dp[indx + 1][transNo + 1],
                        dp[indx + 1][transNo]
                    );
                }
                else                    // Sell
                {
                    dp[indx][transNo] = max(
                        prices[indx] + dp[indx + 1][transNo + 1],
                        dp[indx + 1][transNo]
                    );
                }
            }
        }

        return dp[0][0];
    }
};