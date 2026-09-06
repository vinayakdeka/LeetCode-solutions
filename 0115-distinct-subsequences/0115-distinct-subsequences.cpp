class Solution {
public:

    int f(int i, int j, string s, string t,
          vector<vector<int>>& dp) {

        // Empty t can always be formed
        if (j == 0)
            return 1;

        // s is empty but t is not
        if (i == 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s[i - 1] == t[j - 1]) {

            // Take + Not take
            return dp[i][j] =
                f(i - 1, j - 1, s, t, dp)
                +
                f(i - 1, j, s, t, dp);
        }

        // Characters don't match
        return dp[i][j] =
            f(i - 1, j, s, t, dp);
    }

    int numDistinct(string s, string t) {

        int n = s.size();
        int m = t.size();

        vector<vector<int>> dp(
            n + 1,
            vector<int>(m + 1, -1)
        );

        return f(n, m, s, t, dp);
    }
};