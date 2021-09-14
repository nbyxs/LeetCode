package LeetCode.DP;
/*
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

    你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。

示例:

输入: [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO309BestTimetoBuyandSellStockwithCooldown {
    public  static int maxProfit(int[] prices) {

        int n=prices.length;
        if(n<=1)return 0;
        int[][] dp=new int[n+1][4];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[0][2]=0;
        dp[0][3]=0;
        for(int i=1;i<n;++i){
            dp[i][0]=dp[i-1][0];
            dp[i][1]=Math.max(dp[i-1][0]-prices[i],Math.max(dp[i-1][1],dp[i-1][3]-prices[i]));
            dp[i][2]=Math.max(dp[i-1][1]+prices[i],dp[i-1][2]);
            dp[i][3]=Math.max(dp[i-1][2],dp[i-1][3]);
        }
        return Math.max(dp[n-1][2],dp[n-1][3]);
    }
    public  static int maxProfit_(int[] prices){
        int n=prices.length;
        if(n<=1)return 0;
        int now=0;
        int buy=-prices[0];
        int sell=0;
        int stop=0;
        for(int i=1;i<n;++i){
           int  buy1=Math.max(buy,Math.max(now-prices[i],stop-prices[i]));
           int  sell1=Math.max(sell,buy+prices[i]);
            stop=Math.max(sell,stop);
            buy=buy1;
            sell=sell1;
        }
        return sell;
    }
    public static void main(String[] args) {
        int[] prices={1,2,3,0,2};
        System.out.println(maxProfit_(prices));
    }
}
