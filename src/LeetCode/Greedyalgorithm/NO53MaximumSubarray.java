package LeetCode.Greedyalgorithm;
/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
示例 1：
输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
示例 2：
输入：nums = [1]
输出：1
示例 3：
输入：nums = [0]
输出：0
示例 4：
输入：nums = [-1]
输出：-1
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum=0;
        for(int num:nums){
            if(sum>0){
                //不全是负数则必有大于0的和
                sum += num;
            }else{
                //如果全是负数那么选最小负数
                sum=num;
            }
            ans=Math.max(ans,sum);

        }
        return ans;
    }
}
