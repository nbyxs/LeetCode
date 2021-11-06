package LeetCode.DFS;

public class NO200 {

    public int numIslands(char[][] grid) {

        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;++i){
            for(int j=0;j>m;++j){
                if(grid[i][j]=='1'){
                    ++ans;
                    dfs(grid,i,j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int i, int j) {
        int n=grid.length;
        int m=grid[0].length;
        if(i<0||j>=m||i>=n||j<0||grid[i][j]=='0')return;
        grid[i][j]='0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
