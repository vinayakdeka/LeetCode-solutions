import java.util.*;

class Tuple {
    int first;
    int second;
    int third;

    Tuple(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // Start or destination is blocked
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
            return -1;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int) 1e9);
        }

        Queue<Tuple> q = new LinkedList<>();

        // Starting cell has path length 1
        dist[0][0] = 1;
        q.add(new Tuple(1, 0, 0));

        // 8 directions
        int[] delrow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] delcol = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (!q.isEmpty()) {

            Tuple it = q.remove();

            int dis = it.first;
            int row = it.second;
            int col = it.third;

            // Destination reached
            if (row == n - 1 && col == m - 1)
                return dis;

            for (int i = 0; i < 8; i++) {

                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    grid[nrow][ncol] == 0 &&
                    dis + 1 < dist[nrow][ncol]) {

                    dist[nrow][ncol] = dis + 1;

                    q.add(new Tuple(dis + 1, nrow, ncol));
                }
            }
        }

        return -1;
    }
}