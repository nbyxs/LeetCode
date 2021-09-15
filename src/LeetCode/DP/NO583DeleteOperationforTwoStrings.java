package LeetCode.DP;
/*
给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
示例：
输入: "sea", "eat"
输出: 2
解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO583DeleteOperationforTwoStrings {
    public  static int minDistance(String word1, String word2) {


        int n=word1.length();
        int m=word2.length();
        if(n==0)return m;
        if(m==0)return n;
        int[][] dp=new int[n+1][m+1];
        char[] s1=word1.toCharArray();
        char[] s2=word2.toCharArray();
        for(int i=1;i<=n;++i){
            for(int j=1;j<=m;++j){
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                if(s1[i-1]==s2[j-1])dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+1);
            }
        }
        return (n+m)-dp[n][m]*2;
    }

    public static void main(String[] args) {
        String a="sea";
        String b="eat";
        System.out.println(minDistance(a,b));
    }
}
