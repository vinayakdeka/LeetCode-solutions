class Solution {
public:

    int f(int i, int j, vector<vector<int>>& grid,
          vector<vector<int>>& dp)
    {
        // Base case
        if(i == 0 && j == 0)
            return grid[i][j];

        // Outside the grid
        if(i < 0 || j < 0)
            return INT_MAX;

        // Already calculated
        if(dp[i][j] != -1)
            return dp[i][j];

        int left = f(i, j - 1, grid, dp);
        int up = f(i - 1, j, grid, dp);

        return dp[i][j] = grid[i][j] + min(left, up);
    }

    int minPathSum(vector<vector<int>>& grid) {

        int m = grid.size();
        int n = grid[0].size();

        vector<vector<int>> dp(m, vector<int>(n, -1));

        return f(m - 1, n - 1, grid, dp);
    }
};