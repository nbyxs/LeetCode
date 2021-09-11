package LeetCode.DP;



/*
给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
示例 1:
输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。
示例 2:
输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/integer-break
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
2 <= n <= 58
 */
//dp[i]表示第i个数最大乘积
//dp[i] =max(j*dp[i-j],j*(i-j), dp[i])
//优化 1.dp[i] > j*dp[i-j] (j>=4)恒成立
/*
令 i=j得 dp[j]>j
∴ dp[i-j]>i-j;
∴ dp[i]>j*dp[i-j]>j*(i-j)
∴当i-j>=4时 dp[i]的值与j*dp[i-j],j*(i-j)无关
∴只需考虑j=2和j=3时的情况
当 i≥3时，状态转移方程如下：

dp[i]=max(2×(i−2),2×dp[i−2],3×(i−3),3×dp[i−3])

 */
public class NO343IntegerBreak {
    public  static int integerBreak(int n) {

        int[] dp=new int[60];
        dp[2]=1;
        for(int i=3;i<=n;++i){
            dp[i]=Math.max(Math.max(2*(i-2),2*dp[i-2]),Math.max(3*(i-3),3*dp[i-3]));
        }

        //for(int i=2;i<=n;++i) System.out.print(dp[i]+ " ");
        return  dp[n];
    }



    public static void main(String[] args) {
        int n=8;
        System.out.println(integerBreak(n));
    }
}
