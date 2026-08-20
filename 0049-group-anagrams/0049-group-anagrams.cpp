class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {

        unordered_map<string, vector<string>> map;
        vector<vector<string>> result;

        string temp;

        for(int i = 0; i < strs.size(); i++)
        {
            temp = strs[i];

            sort(temp.begin(), temp.end());

            map[temp].push_back(strs[i]);
        }

        for(auto it : map)
        {
            result.push_back(it.second);
        }

        return result;
    }
};