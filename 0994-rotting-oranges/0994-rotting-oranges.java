class Node{
    int row,col,tm;
    Node(int row,int col,int tm){
        this.row=row;
        this.col=col;
        this.tm=tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        Queue<Node> q=new LinkedList<Node>();
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Node(i,j,0));
                    vis[i][j]=2;
                }
                else
                    vis[i][j]=0;
                if(grid[i][j]==1)
                    fresh++;
            }
        }
        int mt=0;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        int cn=0;
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().tm;
            mt=Math.max(mt,t);
            q.remove();
            for(int i=0;i<4;i++){
                int nr=r+drow[i];
                int nc=c+dcol[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&vis[nr][nc]==0&&grid[nr][nc]==1)           {
                    q.add(new Node(nr,nc,t+1));
                    cn++;
                    vis[nr][nc]=2;
                }
            }
        }
        if(cn!=fresh)return -1;
        else
        return mt;
    }
}