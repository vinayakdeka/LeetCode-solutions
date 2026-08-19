class Solution {
public:
    string minWindow(string s, string t) {

        int n = s.size();
        int m = t.size();

        int cnt = 0;

        int l = 0;
        int r = 0;

        int minlen = INT_MAX;
        int start = -1;

        unordered_map<char, int> hash;

        // Store frequency of characters in t
        for(int i = 0; i < m; i++) {
            hash[t[i]]++;
        }

        while(r < n) {

            // Include s[r] in the window
            if(hash[s[r]] > 0) {
                cnt++;
            }

            hash[s[r]]--;

            // When window contains all characters of t
            while(cnt == m) {

                // Update minimum window
                if(r - l + 1 < minlen) {
                    minlen = r - l + 1;
                    start = l;
                }

                // Remove s[l] from window
                hash[s[l]]++;

                if(hash[s[l]] > 0) {
                    cnt--;
                }

                l++;
            }

            r++;
        }

        if(start == -1)
            return "";

        return s.substr(start, minlen);
    }
};