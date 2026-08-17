class Solution {
public:
    int dp[500][500];
    vector<int> prefix;

    int solve(vector<int>& stoneValue, int i, int j) {

        // Only one stone
        if (i >= j) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;

        int leftSum = 0;
        int rightSum = prefix[j + 1] - prefix[i];

        for (int k = i; k < j; k++) {

            // Move one stone from right to left
            leftSum += stoneValue[k];
            rightSum -= stoneValue[k];

            // Left part is smaller
            if (leftSum < rightSum) {

                // Pruning
                if (ans >= 2 * leftSum) {
                    continue;
                }

                ans = max(
                    ans,
                    leftSum + solve(stoneValue, i, k)
                );
            }

            // Right part is smaller
            else if (leftSum > rightSum) {

                // Pruning
                if (ans >= 2 * rightSum) {
                    break;
                }

                ans = max(
                    ans,
                    rightSum + solve(stoneValue, k + 1, j)
                );
            }

            // Both parts have equal sum
            else {

                ans = max(
                    ans,
                    max(
                        leftSum + solve(stoneValue, i, k),
                        rightSum + solve(stoneValue, k + 1, j)
                    )
                );
            }
        }

        return dp[i][j] = ans;
    }

    int stoneGameV(vector<int>& stoneValue) {

        int n = stoneValue.size();

        // Prefix sum
        prefix.resize(n + 1, 0);

        for (int i = 0; i < n; i++) {
            prefix[i + 1] =
                prefix[i] + stoneValue[i];
        }

        // Initialize DP
        memset(dp, -1, sizeof(dp));

        return solve(stoneValue, 0, n - 1);
    }
};