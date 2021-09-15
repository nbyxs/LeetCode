package LeetCode.DP;
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
示例 5：
输入：nums = [-100000]
输出：-100000
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO53MaximumSubarray {
    public  static int maxSubArray(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }
        int maxSubArray = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            //sum要想有资格继续壮大 就必须大于 0 否则还不如恢复0
            sum = Math.max(sum,0);
            //恢复0之后再相加，如果数组皆为负数，想和最大-->数组中最大（绝对值最小）的负数
            //则这条语句相当于取出全是负数中的最大数
            sum += nums[i];
            //maxSubArray始终取最大值
            maxSubArray = Math.max(sum,maxSubArray);

        }
        return maxSubArray;
    }

    public static void main(String[] args) {
        int[] a={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
    }
}
