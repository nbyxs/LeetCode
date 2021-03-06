package LeetCode.DP;
/*
给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
   例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
示例 1：
输入：text1 = "abcde", text2 = "ace"
输出：3
解释：最长公共子序列是 "ace" ，它的长度为 3 。
示例 2：
输入：text1 = "abc", text2 = "abc"
输出：3
解释：最长公共子序列是 "abc" ，它的长度为 3 。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-common-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO1143LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        if(n==0||m==0)return 0;
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;++i)
            for(int j=1;j<=m;++j){
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j]=Math.max(dp[i-1][j-1]+1,dp[i][j]);
            }
        return dp[n][m];
    }
    public static int longestCommonSubsequence_review(String text1, String text2){
        int n=text1.length();
        int m=text2.length();
        if(n*m==0)return 0;
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;++i){
            for(int j=1;j<=m;++j){
                dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=Math.max(dp[i-1][j-1]+1,dp[i][j]);
                }
            }
        }
//          for(int i=1;i<=n;++i){
//            for(int j=1;j<=m;++j){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String a="abed";
        String b="ad";
        System.out.println(longestCommonSubsequence(a,b));
        System.out.println(longestCommonSubsequence_review(a,b));
    }
}
