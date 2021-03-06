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
 */
public class NO343IntegerBreak {
    public int integerBreak(int n) {

        int[] dp=new int[60];
        dp[2]=1;
        for(int i=2;i<=n;++i){
            for(int j=1;j<=i-1;++j){

                dp[i]=Math.max(Math.max(j*dp[i-j],j*(i-j)),dp[i]);
            }
        }

        return  dp[n];
    }
    public static int integerBreak_review(int n){
        if(n==2)return 1;
        if(n==3)return 2;
        int number=n%3;
        int count=n/3;
        if(number==0)return (int) Math.pow(3,count);
        if(number==1)return (int) (Math.pow(3,count-1))*4;
        return (int) (Math.pow(3,count))*2;
    }

    public static void main(String[] args) {
        System.out.println(integerBreak_review(8));
    }
}
