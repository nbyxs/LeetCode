package LeetCode.DP.zero_onebackpack;
/*
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
示例 1：
输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
示例 2：
输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO416PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {

        int sum=0;
        int n=nums.length;
        //System.out.println(n);
        for(int i=0;i<n;++i)sum+=nums[i];
        if((sum&1)==1)return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for(int i = 0; i < n; i++){
            for(int j = target; j >= nums[i]; j--){
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
    public static boolean canPartition_review(int[] nums){
        int n=nums.length;
        if(nums==null||n==0)return false;
        int sum=0;
        for(int num:nums)sum+=num;
        if((sum&1)==1)return false;
        int target=sum>>1;
        int[] dp=new int[target+1];
        for(int i=0;i<n;++i){
            for(int j=target;j>=nums[i];--j){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[target]==target;
    }
    public static void main(String[] args) {
        int[] a={1,1};
        System.out.println(canPartition_review(a));
    }
}
