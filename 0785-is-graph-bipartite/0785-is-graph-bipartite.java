import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        
        // Initialize all nodes as uncolored (-1)
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }

        // Loop through all nodes to handle disconnected components
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                // Start BFS from an uncolored component
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 0; // Assign the first color

                while (!queue.isEmpty()) {
                    int node = queue.poll();

                    for (int neighbor : graph[node]) {
                        // If the neighbor is uncolored, give it the opposite color
                        if (color[neighbor] == -1) {
                            color[neighbor] = 1 - color[node];
                            queue.add(neighbor);
                        } 
                        // If it has the same color as the current node, an odd cycle is found
                        else if (color[neighbor] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}