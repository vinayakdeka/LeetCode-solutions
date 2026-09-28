class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int vis[][] = new int[n][m];
        int ans[][] = new int[n][m];

        // Put all 0's into the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (vis[i][j] == 0 && mat[i][j] == 0) {

                    vis[i][j] = 1;

                    // row, col, steps
                    q.add(new int[]{i, j, 0});
                }
            }
        }

        int delrow[] = {-1, 0, 1, 0};
        int delcol[] = {0, 1, 0, -1};

        // BFS
        while (!q.isEmpty()) {

            int curr[] = q.poll();

            int row = curr[0];
            int col = curr[1];
            int steps = curr[2];

            ans[row][col] = steps;

            for (int i = 0; i < 4; i++) {

                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    vis[nrow][ncol] == 0) {

                    vis[nrow][ncol] = 1;

                    q.add(new int[]{nrow, ncol, steps + 1});
                }
            }
        }

        return ans;
    }
}