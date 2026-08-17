class Solution {
public:
    int atMostk(vector<int>& nums, int k) {

        int l = 0;
        int count = 0;
        int sum = 0;
        int n = nums.size();
        int r = 0;
        if(k<0) return 0;
        while(r<nums.size())
        {
            sum+= nums[r]%2;

            while(sum>k)
            { 
                sum-= nums[l]%2;
                l = l + 1;
            }
            count = count + r - l + 1;
            r = r + 1;
        }

        return count;
    }
        int numberOfSubarrays(vector<int>& nums, int k) 
        {
            return atMostk(nums,k) - atMostk(nums,k-1);
        } 
};