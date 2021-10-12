package LeetCode.DP.zero_onebackpack;
/*
给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
示例 1：
输入：n = 3
输出：5
示例 2：
输入：n = 1
输出：1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-binary-search-trees
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO96UniqueBinarySearchTrees {
    public static int numTrees(int n) {

        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;++i){
            for(int j=1;j<=i;++j)
                dp[i]+=dp[j-1]*dp[i-j];
        }
        return dp[n];
    }
    public static int numTrees_review(int n){
        if(n==0)return 1;
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;++i){
            for(int j=1;j<=i;++j){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];

    }
    public static int numTrees1(int n){
        long  sum=1;
        for(int i=1;i<=n;++i)sum=2*(2*i-1)*sum/(i+1);
        return (int)sum;
    }
    public static void main(String[] args) {
        int n=3;
        System.out.println(numTrees1(n));
    }
}
