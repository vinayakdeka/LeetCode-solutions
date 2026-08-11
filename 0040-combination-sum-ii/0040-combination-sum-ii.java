class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        Arrays.sort(candidates);
        int sum[] = new int[1]; //stores only 1 value in the sum value by reference here
        int i =0;
        backtrack(candidates,0,target,ans,set,sum);
        return ans;        
    }

    private void backtrack(int[] candidates,int i, int target,List<List<Integer>> ans,  List<Integer>set , int sum[])
    {
        if(sum[0] == target)
        {
            ans.add(new ArrayList<>(set));
            return;
        }

        for(int j = i;j<candidates.length;j++)
        {
            if(j>i && candidates[j] == candidates[j-1])
            {
                continue;
            }

            if(candidates[j] + sum[0] > target)
            {
                break;
            }

            set.add(candidates[j]);
            sum[0] += candidates[j];
            backtrack(candidates,j+1,target,ans,set,sum);
            set.remove(set.size()-1);
            sum[0] -= candidates[j];
           
        }      
    }
}