class Solution {
public:
    int longestSubsequence(vector<int>& nums) {
        int n = nums.size();
        int totalXOR = 0;
        bool hasnonzero = false;

        for(int x:nums)
        {
            totalXOR^= x;
             if(x!=0)
             hasnonzero = true;

        }

        if(totalXOR!=0)
        {
            return n;
        }
        if(hasnonzero)
        {
            return n-1;
        }
        return 0;
        
    }
};