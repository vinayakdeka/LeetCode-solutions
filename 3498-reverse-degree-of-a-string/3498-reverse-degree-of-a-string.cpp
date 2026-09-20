class Solution {
public:
    int reverseDegree(string s) {
        int ans = 0;
        int n = s.size();
        int i = 0;

        while(i<n)
        {
            int prod = 26 - (s[i] - 'a');
            int index = i + 1;
            ans += prod * index;
            i++;
        }

        return ans;
        
    }
};