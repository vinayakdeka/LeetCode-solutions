class Solution {
public:
    int largestOverlap(vector<vector<int>>& img1, vector<vector<int>>& img2) {
        
        int n = img1.size(), ans = 0;
        map<pair<int,int>, int> mp;

        vector<pair<int,int>> x, y;

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++) {
                if(img1[i][j]) x.push_back({i,j});
                if(img2[i][j]) y.push_back({i,j});
            }

        for(auto p : x)
            for(auto q : y)
                ans = max(ans, ++mp[{p.first-q.first, p.second-q.second}]);

        return ans;
    }
};