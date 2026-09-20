class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {

        // {distance, node}
        priority_queue<
            pair<int, int>,
            vector<pair<int, int>>,
            greater<pair<int, int>>
        > pq;

        vector<int> dist(n + 1, 1e9);

        // Build adjacency list
        vector<vector<pair<int, int>>> adj(n + 1);

        for (auto it : times) {
            int u = it[0];
            int v = it[1];
            int wt = it[2];

            adj[u].push_back({v, wt});
        }

        dist[k] = 0;
        pq.push({0, k});

        while (!pq.empty()) {

            int d = pq.top().first;
            int node = pq.top().second;
            pq.pop();

            // Ignore stale entry
            if (d > dist[node])
                continue;

            for (auto it : adj[node]) {

                int adjNode = it.first;
                int edgeWeight = it.second;

                if (d + edgeWeight < dist[adjNode]) {

                    dist[adjNode] = d + edgeWeight;

                    pq.push({
                        dist[adjNode],
                        adjNode
                    });
                }
            }
        }

        int ans = 0;

        // Nodes are 1-indexed
        for (int i = 1; i <= n; i++) {

            if (dist[i] == 1e9)
                return -1;

            ans = max(ans, dist[i]);
        }

        return ans;
    }
};