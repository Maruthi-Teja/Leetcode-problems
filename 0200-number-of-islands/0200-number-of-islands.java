class Solution {
    public int numIslands(char[][] grid) {
        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    checkIsland(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void checkIsland(char[][] grid,int n,int m){
        

        if(n<grid.length && m<grid[0].length && n>=0 && m>=0 && grid[n][m]=='1'){
            grid[n][m] = '2';
            checkIsland(grid,n+1,m);
            checkIsland(grid,n,m+1);
            checkIsland(grid,n-1,m);
            checkIsland(grid,n,m-1);
        }

    }
}