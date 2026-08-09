class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {

        int n = nums.size(); // Size of the array

        sort(nums.begin(), nums.end());

        vector<int> ans;       // To store the LDS
        vector<int> dp(n, 1);  // DP array
        vector<int> parent(n); // Array to keep record of the parent

        // To store the index of last element in the LDS
        int lastIndex = 0;

        // To store the length of LDS
        int maxLen = 0;

        // Computing the DP array
        for (int i = 0; i < n; i++) {

            parent[i] = i; // Assign the parent to itself

            // For each previous index
            for (int j = 0; j < i; j++) {

                // If nums[i] can be included in the
                // LDS ending at nums[j]
                if (nums[i] % nums[j] == 0 &&
                    dp[i] < dp[j] + 1) {

                    dp[i] = dp[j] + 1; // Update DP value
                    parent[i] = j;     // Store the parent
                }
            }

            // If a longer LDS is found, update the values
            if (dp[i] > maxLen) {
                lastIndex = i;
                maxLen = dp[i];
            }
        }

        // Backtracking
        int i = lastIndex;

        // Until we reach an index which is its own parent
        while (parent[i] != i) {

            ans.push_back(nums[i]);

            i = parent[i];
        }

        // Add the first element
        ans.push_back(nums[i]);

        // Reverse because we collected elements backwards
        reverse(ans.begin(), ans.end());

        return ans;
    }
};