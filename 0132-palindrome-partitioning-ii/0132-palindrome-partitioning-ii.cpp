class Solution {
public:

   bool isPalindrome(int i, int j, string &s)
   {
    while(i<j) 
    {if(s[i]!=s[j])
    return false;
    i++;
    j--;
    }
     return true;
   }
   int f(int i,string &s, int n, vector<int> &dp)
   {
    if(i==n) return 0;
    if(dp[i]!=-1) return dp[i];
    int mincost = INT_MAX;
    for(int j = i; j<n;j++)
    { 
        if(isPalindrome(i,j,s))
        {
            int cost = 1 + f(j+1,s,n,dp);
            mincost = min(mincost,cost);
        }
    }
    return dp[i] = mincost;
   }

    int minCut(string s) {
        int n = s.size();
        vector<int> dp(n+1,-1);
        return f(0,s,n,dp) - 1;
        
    }
};