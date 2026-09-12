class Solution {
public:

    void Merge(int low,int mid,int high,vector<int> &nums)
    {
       vector<int> temp;
       int k = 0;
       int i = low;
       int j = mid+1;

       while(i<=mid && j<=high)
       {
        if(nums[i]<=nums[j])
        {
           temp.push_back(nums[i++]);
        }
        else
        {
            temp.push_back(nums[j++]);
        }
      }

      while(i<=mid)
      {
         temp.push_back(nums[i++]);
      }

      while(j<=high)
      {
        temp.push_back(nums[j++]);
      }

      for(int k = 0; k<temp.size();k++)
      {
        nums[low + k] = temp[k];
      }
    }

    int CountPairs(vector<int>& nums,int low, int mid,int high)
    {
        int cnt = 0;
        int right = mid+1;
        for(int i = low; i<=mid; i++)
        {
           while(right<=high && nums[i] > 2LL * nums[right])
           {
            right++;
           }
           cnt+= right - (mid+1);
        }
        return cnt;
    }

     int MergeSort(vector<int>& nums,int low, int high)
    {
       if(low>=high) return 0;

          int mid = low + (high-low)/2;
          int countPairs = 0;
          countPairs+= MergeSort(nums,low,mid);
          countPairs+=  MergeSort(nums,mid+1,high);
          countPairs+= CountPairs(nums,low,mid,high);
          Merge(low, mid, high,nums);

         return countPairs;
       }
    int reversePairs(vector<int>& nums) {

        return MergeSort(nums,0,nums.size()-1);
    }
};