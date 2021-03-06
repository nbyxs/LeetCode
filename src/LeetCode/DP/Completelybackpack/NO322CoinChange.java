package LeetCode.DP.Completelybackpack;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
示例 1：
输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1
示例 2：
输入：coins = [2], amount = 3
输出：-1
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-change
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//dp[j] 表示和为j 需要数的最小个数
public class NO322CoinChange {
    public int coinChange(int[] coins, int amount) {

        int[] dp=new int[amount+1];
        for(int i=0;i<amount+1;++i)dp[i]=10000;
        dp[0]=0;
        for(int i=0;i<coins.length;++i)
            for(int j=coins[i];j<=amount;++j)
                dp[j]=Math.min(dp[j-coins[i]]+1,dp[j]);
        return dp[amount]==10000?-1:dp[amount];
    }
    public static int coinChange_review(int[] coins, int amount){
        int[] dp=new int[amount+1];
        for(int i=0;i<amount+1;++i)dp[i]=10000;
        dp[0]=0;
        for(int i=0;i<coins.length;++i)
            for(int j=coins[i];j<=amount;++j)
                dp[j]=Math.min(dp[j-coins[i]]+1,dp[j]);
        return dp[amount]==10000?-1:dp[amount];
    }

    public static void main(String[] args) {
        int[] a={1,2,3};
        int target=4;
        System.out.println(coinChange_review(a,target));
    }
}
