class Solution {
public:

   long long f(int indx, int buy, vector<int>&prices, int n ,vector<vector<int>> &dp)
   {

     long long profit = 0;

     if(indx == n) return 0; // buys at the end but doesn't sell it 

     if(dp[indx][buy]!=-1)
     {
        return dp[indx][buy];
     }

     if(buy)
     {
        profit = max(-prices[indx] + f(indx+1,0,prices,n,dp), 0 + f(indx+1,1,prices,n,dp));
     }
     else
     {
        profit = max(prices[indx] + f(indx+1,1,prices,n,dp), 0 + f(indx+1,0,prices,n,dp));
     }

     return dp[indx][buy] = profit;

   }



    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> dp(n, vector<int>(2,-1));
        return f(0,1,prices,n,dp);

        
    }
};