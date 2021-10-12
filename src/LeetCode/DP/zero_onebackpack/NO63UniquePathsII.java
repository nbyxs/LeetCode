package LeetCode.DP.zero_onebackpack;

public class NO63UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] path) {
        int m=path.length;
        int n=path[0].length;
        int[][] dp=new int[m+1][n+1];
        int i=0;
        while(i<m&&path[i][0]==0){
            dp[i][0]=1;
            ++i;
        }
        i=0;
        while(i<n&&path[0][i]==0){
            dp[0][i]=1;
            ++i;
        }
        dp[0][0]=1;
        for( i=1;i<m;++i){
            for(int j=1;j<n;++j){

              if(path[i][j]==1)continue;
              dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }

        }
        for( i=0;i<=m;++i){
            for(int j=0;j<=n;++j){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[m-1][n-1];
    }
    public static int uniquePathsWithObstacles_review(int[][] path){
        int m=path.length;
        int n=path[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<m;++i){
            if(path[i][0]==1)break;
            dp[i][0]=1;
        }
        for(int i=0;i<n;++i){
            if(path[0][i]==1)break;
            dp[0][i]=1;
        }
        for(int i=1;i<m;++i){
            for(int j=1;j<n;++j){
                if(path[i][j]==0)dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        int[][] a={{0,0,0},{0,1,0},{0,0,0}};
        int[][] b={{0,1},{0,0}};
        System.out.println(uniquePathsWithObstacles_review(b));
    }
}
