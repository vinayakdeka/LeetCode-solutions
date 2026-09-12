class Solution {
public:

    struct State {
        long long score;
        vector<int> indices;
    };

    vector<vector<int>> a;
    vector<vector<State>> dp;
    vector<vector<bool>> vis;
    int n;

    State solve(int i, int k) {

        // No intervals left or cannot choose anymore
        if (i == n || k == 0) {
            return {0, {}};
        }

        if (vis[i][k]) {
            return dp[i][k];
        }

        vis[i][k] = true;

        // Option 1: Don't take current interval
        State skip = solve(i + 1, k);

        // Option 2: Take current interval
        int end = a[i][1];

        // Find first interval with start > end
        int next = i + 1;

        int low = i + 1;
        int high = n;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (a[mid][0] > end)
                high = mid;
            else
                low = mid + 1;
        }

        next = low;

        State nxt = solve(next, k - 1);

        State take;
        take.score = a[i][2] + nxt.score;

        take.indices = nxt.indices;
        take.indices.push_back(a[i][3]);

        // Sort indices because answer must be
        // lexicographically compared by original indices
        sort(take.indices.begin(), take.indices.end());

        // Choose better answer
        if (take.score > skip.score) {
            dp[i][k] = take;
        }
        else if (take.score < skip.score) {
            dp[i][k] = skip;
        }
        else {
            if (take.indices < skip.indices)
                dp[i][k] = take;
            else
                dp[i][k] = skip;
        }

        return dp[i][k];
    }

    vector<int> maximumWeight(vector<vector<int>>& intervals) {

        n = intervals.size();

        a.clear();

        // Store original index
        for (int i = 0; i < n; i++) {

            a.push_back({
                intervals[i][0],
                intervals[i][1],
                intervals[i][2],
                i
            });
        }

        // Sort by start position
        sort(a.begin(), a.end());

        dp.assign(n, vector<State>(5));
        vis.assign(n, vector<bool>(5, false));

        return solve(0, 4).indices;
    }
};