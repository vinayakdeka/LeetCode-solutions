class Solution {
public:

   int f(int indx, int buy, int cap ,vector<int>& prices, int n , vector<vector<vector<int>>> &dp)
   {
    if(indx == n || cap == 0) return 0; // cap is the no. of transactions allowed
   
    if(dp[indx][buy][cap] != -1)
    return dp[indx][buy][cap];

    long long profit = 0;
   
   if(buy == 1)
   {
    profit = max(-prices[indx] + f(indx+1,0,cap,prices,n,dp), 0 + f(indx+1,1,cap,prices,n,dp));
   }
   else
   {
    profit = max(prices[indx] + f(indx+1,1,cap-1,prices,n,dp), 0 + f(indx+1,0,cap,prices,n,dp));
   }
   return dp[indx][buy][cap] = profit;
   }


    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<vector<int>>> dp(n,vector<vector<int>> (2,vector<int> (3,-1)));
        return f(0,1,2,prices,n,dp);
        
    }
};