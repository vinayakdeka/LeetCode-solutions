class Solution {
public:
    vector<long long> resultArray(vector<int>& nums, int k) {

        vector<long long> ans(k, 0);

        // dp[r] =
        // number of subarrays ending at the previous index
        // whose product % k == r
        vector<long long> dp(k, 0);

        for (int num : nums) {

            int rem = num % k;

            // dp for subarrays ending at current index
            vector<long long> newDp(k, 0);

            // Start a new subarray containing only num
            newDp[rem] = 1;

            // Extend previous subarrays by num
            for (int r = 0; r < k; r++) {

                int newRem = (r * rem) % k;

                newDp[newRem] += dp[r];
            }

            // Add current subarrays to final answer
            for (int r = 0; r < k; r++) {
                ans[r] += newDp[r];
            }

            dp = newDp;
        }

        return ans;
    }
};