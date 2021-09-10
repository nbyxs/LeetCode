package LeetCode.DP;
/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
问总共有多少条不同的路径？
示例 1：
输入：m = 3, n = 7
输出：28
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO62UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;++i)dp[i][0]=1;
        for(int i=0;i<=n;++i)dp[0][i]=1;
        dp[0][0]=1;
        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j)
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
        }
         for(int i=0;i<=m;++i){
            for(int j=0;j<=n;++j){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

         return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int m=3 ;
        int n=7;
        System.out.println(uniquePaths(m,n));
    }
}
