class Solution {
public:
    int missingInteger(vector<int>& nums) {

        int sum = nums[0];

        int n = nums.size();

        for(int i = 1; i<n; i++)
        {
            if(nums[i] == nums[i-1] + 1)
            {
                sum+= nums[i];
            }
            else
            {
                break;
            }
        }
        
        unordered_set<int> st(nums.begin(),nums.end());

        int x = sum;

        while(st.find(x) != st.end())
        {
            x++;
        }
        return x;
    }
};