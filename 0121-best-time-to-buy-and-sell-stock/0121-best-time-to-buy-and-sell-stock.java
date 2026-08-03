class Solution {
    public int maxProfit(int[] prices) {

        int minprice = prices[0];
        int profit = 0;
        int n = prices.length;
   
        for(int i = 0; i<n; i++)
        {
            int cost = prices[i] - minprice;
            profit = Math.max(profit,cost);
            minprice = Math.min(prices[i],minprice);
        }
        return profit;
    }
}