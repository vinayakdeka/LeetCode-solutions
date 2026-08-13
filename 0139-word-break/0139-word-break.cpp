class Solution {
public:
   unordered_set<string> st;
    int t[301];
   bool solve(int indx, string &s)
   {
      int n = s.length();
      if(indx >= n)
      {
        return true;
      }

      if(t[indx]!=-1)
      {
        return t[indx];
      }

      if(st.find(s)!=st.end())
      {
        return true;
      }

     for(int l = 1; l<=n ;l++)
     {
        string temp = s.substr(indx,l);
        if(st.find(temp)!=st.end() && solve(indx+l,s))
        {
            return t[indx] = true;
        }
     }
     return t[indx] = false;

   }
    bool wordBreak(string s, vector<string>& wordDict) {
         int n = s.length();
          for(string &word: wordDict)
        {
        st.insert(word);
        }
         memset(t,-1,sizeof(t));
         return solve(0,s);
    }
};