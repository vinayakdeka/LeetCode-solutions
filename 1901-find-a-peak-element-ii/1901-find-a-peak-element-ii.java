class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int l = 0;
        int r = m - 1;

        while(l<=r)
        {
            int maxrow = 0;
             int mid = l + (r - l)/2;
             for(int i = 0 ; i < n; i++)
             {
             if(mat[i][mid] > mat[maxrow][mid])
             {
                maxrow = i;
             }
            }

             int left = (mid > 0) ? mat[maxrow][mid-1] : -1;
             int right = (mid < m-1) ? mat[maxrow][mid+1] : -1;

             if(mat[maxrow][mid] > left && mat[maxrow][mid] > right)
             {
                return new int[]{maxrow,mid};
             }
             else if(mat[maxrow][mid] < left)
             r = mid - 1;
             else
             {
                l = mid + 1;
             }
        }

        return new int[]{-1,-1};
        
    }
}