class Solution {
private:
    bool checkCycle(int node, vector<vector<int>>& adj,
                    vector<int>& vis, vector<int>& dfsVis) {

        vis[node] = 1;
        dfsVis[node] = 1;

        for (int it : adj[node]) {

            // Node is not visited
            if (vis[it] == 0) {
                if (checkCycle(it, adj, vis, dfsVis)) {
                    return true;
                }
            }

            // Node is already present in current DFS path
            else if (dfsVis[it] == 1) {
                return true;
            }
        }

        // Remove node from current DFS path
        dfsVis[node] = 0;

        return false;
    }

public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {

        // Create adjacency list
        vector<vector<int>> adj(numCourses);

        // [a, b] means b -> a
        for (auto it : prerequisites) {
            int a = it[0];
            int b = it[1];

            adj[b].push_back(a);
        }

        vector<int> vis(numCourses, 0);
        vector<int> dfsVis(numCourses, 0);

        // Graph can have multiple components
        for (int i = 0; i < numCourses; i++) {

            if (vis[i] == 0) {

                if (checkCycle(i, adj, vis, dfsVis)) {
                    return false;
                }
            }
        }

        return true;
    }
};