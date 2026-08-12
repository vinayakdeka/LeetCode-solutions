class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();
        vector<int> prev(amount+1,0);
        vector<int> curr(amount+1,0);

        for(int t = 0; t<=amount; t++)
        {
            if(t % coins[0] == 0) prev[t] = t/coins[0];
            else prev[t] = 1e9;
        }

        for(int indx = 1; indx<n; indx++)
        {
            for(int t = 0; t<=amount;t++)
            {
                int nottake = 0 + prev[t];
                int take = INT_MAX;
                if(coins[indx] <= t)
                {
                take = 1 + curr[t - coins[indx]];
                }
              curr[t] = min(take,nottake);
            }
            prev = curr;
        }

        int ans = prev[amount];
        if(ans>= 1e9)
        return -1;
        return ans;
        
    }
};