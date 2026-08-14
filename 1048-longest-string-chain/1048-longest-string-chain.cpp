class Solution {
public:

    bool comparePossible(string &s1, string &s2)
    {
        // s1 must have exactly one extra character
        if(s1.size() != s2.size() + 1)
            return false;

        int first = 0;
        int second = 0;

        while(first < s1.size() && second < s2.size())
        {
            if(s1[first] == s2[second])
            {
                first++;
                second++;
            }
            else
            {
                first++;
            }
        }

        return second == s2.size();
    }

    bool com(string &s1, string &s2)
    {
        return s1.size() < s2.size();
    }

    int longestStrChain(vector<string>& words)
    {
        int n = words.size();

        // Sort according to length
        sort(words.begin(), words.end(), [](string &s1, string &s2) {
        return s1.size() < s2.size();
});
        // Every word itself is a chain of length 1
        vector<int> dp(n, 1);

        int maxi = 1;

        for(int i = 1; i < n; i++)
        {
            for(int prev = 0; prev < i; prev++)
            {
                if(comparePossible(words[i], words[prev]))
                {
                    dp[i] = max(dp[i], dp[prev] + 1);
                }
            }

            maxi = max(maxi, dp[i]);
        }

        return maxi;
    }
};