class Solution {
public:

    bool canSit(unordered_set<int>& reserved,
                int a, int b, int c, int d) {

        return reserved.count(a) == 0 &&
               reserved.count(b) == 0 &&
               reserved.count(c) == 0 &&
               reserved.count(d) == 0;
    }

    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {

        unordered_map<int, unordered_set<int>> mp;

        // Store reserved seats row-wise
        for (auto &x : reservedSeats) {
            mp[x[0]].insert(x[1]);
        }

        // Rows having no reserved seats
        int ans = (n - mp.size()) * 2;

        // Process only affected rows
        for (auto &[row, reserved] : mp) {

            bool left = canSit(reserved, 2, 3, 4, 5);

            bool middle = canSit(reserved, 4, 5, 6, 7);

            bool right = canSit(reserved, 6, 7, 8, 9);

            if (left && right) {
                // Two families can sit
                ans += 2;
            }
            else if (left || middle || right) {
                // Only one family can sit
                ans += 1;
            }
        }

        return ans;
    }
};