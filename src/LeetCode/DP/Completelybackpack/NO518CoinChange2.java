package LeetCode.DP.Completelybackpack;
/*
给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。

请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
假设每一种面额的硬币有无限个。
题目数据保证结果符合 32 位带符号整数。
示例 1：
输入：amount = 5, coins = [1, 2, 5]
输出：4
解释：有四种方式可以凑成总金额：
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-change-2
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO518CoinChange2 {
    public  static int change(int amount, int[] coins) {

        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int i=0;i<coins.length;++i){
            for(int j=coins[i];j<=amount;++j)
                dp[j]+=dp[j-coins[i]];
        }
        return dp[amount];
    }
    public  static int change_review(int amount, int[] coins){
        int n=coins.length;
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int i=0;i<n;++i){
            for(int j=coins[i];j<=amount;++j)
                dp[j]+=dp[j-coins[i]];
        }
        return dp[amount];
    }
    public static void main(String[] args) {
        int[] a={1,2,5};
        int m=5;
        System.out.println(change_review(m,a));
    }
}
