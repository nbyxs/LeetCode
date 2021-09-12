package LeetCode.DP.Completelybackpack;
/*
给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
题目数据保证答案符合 32 位整数范围。
示例 1：
输入：nums = [1,2,3], target = 4
输出：7
解释：
所有可能的组合为：
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
请注意，顺序不同的序列被视作不同的组合。
示例 2：
输入：nums = [9], target = 3
输出：0

 */
public class NO377CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {

        int[] dp=new int[target+1];
        dp[0]=1;

//如果求组合数就是外层for循环遍历物品，内层for遍历背包。
//
//如果求排列数就是外层for遍历背包，内层for循环遍历物品。
//
//如果把遍历nums（物品）放在外循环，遍历target的作为内循环的话，举一个例子：计算dp[4]的时候，结果集只有 {1,3} 这样的集合，不会有{3,1}这样的集合，因为nums遍历放在外层，3只能出现在1后面！
//
//所以本题遍历顺序最终遍历顺序：target（背包）放在外循环，将nums（物品）放在内循环，内循环从前到后遍历。
        for(int i=0;i<=target;++i)//遍历顺序注意
            for(int j=0;j<nums.length;++j)
                if(i>=nums[j])dp[i]+=dp[i-nums[j]];
        return dp[target];
    }
}
