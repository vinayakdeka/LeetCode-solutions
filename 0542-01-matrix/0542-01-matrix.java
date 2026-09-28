class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        // Queue stores: {row, col, steps}
        Queue<int[]> q = new LinkedList<>();

        // vis[i][j] = 1 means this cell has already been visited
        int vis[][] = new int[n][m];

        // Stores the final minimum distance of every cell from 0
        int ans[][] = new int[n][m];

        // Put all 0's into the queue first
        // This is called Multi-Source BFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (vis[i][j] == 0 && mat[i][j] == 0) {

                    // Mark the 0 as visited
                    vis[i][j] = 1;

                    // A 0 is already at distance 0 from itself
                    q.add(new int[]{i, j, 0});
                }
            }
        }

        // Directions: up, right, down, left
        int delrow[] = {-1, 0, 1, 0};
        int delcol[] = {0, 1, 0, -1};

        // Start BFS
        while (!q.isEmpty()) {

            // Get the current cell
            int curr[] = q.poll();

            int row = curr[0];
            int col = curr[1];
            int steps = curr[2];

            // Store the distance of this cell from the nearest 0
            ans[row][col] = steps;

            // Check all 4 adjacent cells
            for (int i = 0; i < 4; i++) {

                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                // Check if the new cell is inside the matrix
                // and has not been visited yet
                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    vis[nrow][ncol] == 0) {

                    // Mark the cell as visited
                    vis[nrow][ncol] = 1;

                    // Move one step further from the current cell
                    q.add(new int[]{nrow, ncol, steps + 1});
                }
            }
        }

        // Return the matrix containing minimum distances
        return ans;
    }
}