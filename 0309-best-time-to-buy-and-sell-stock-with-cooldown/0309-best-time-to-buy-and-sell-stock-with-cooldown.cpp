class Solution {
public:
   int f(int indx, int buy,vector<int>& prices,vector<vector<int>> &dp){
   if(indx >= prices.size()) return 0;

   if(dp[indx][buy] != -1) return dp[indx][buy];

   long long profit = 0;

   if(buy==1)
   {
     profit = max(-prices[indx] + f(indx+1,0,prices,dp), f(indx+1,1,prices,dp));
   }
   else
   {
    profit = max(prices[indx] + f(indx+2,1,prices,dp), f(indx+1,0,prices,dp));
   }
   return dp[indx][buy] = profit;
   }

    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> dp(n, vector<int> (2,-1));
        return f(0,1,prices,dp);
        
    }
};