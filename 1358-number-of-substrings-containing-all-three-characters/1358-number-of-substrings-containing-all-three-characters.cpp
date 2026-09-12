class Solution {
public:
    int numberOfSubstrings(string s) {

         // Initialize frequency map for 'a', 'b', and 'c'
        vector<int> freq(3, 0);

        // Initialize result to store count of valid substrings
        int res = 0;

        // Initialize left pointer of the sliding window
        int left = 0;

        // Traverse the string using right pointer
        for (int right = 0; right < s.length(); right++) {
            // Increment frequency of current character
            freq[s[right] - 'a']++;

            // Shrink the window from the left while all three characters are present
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                // Count all substrings from current right to end
                res += (s.length() - right);

                // Decrease frequency of character at left and move left forward
                freq[s[left] - 'a']--;
                left++;
            }
        }

        return res;
        
    }
};