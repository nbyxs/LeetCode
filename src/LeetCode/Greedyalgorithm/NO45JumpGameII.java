package LeetCode.Greedyalgorithm;
/*
给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
你的目标是使用最少的跳跃次数到达数组的最后一个位置。
假设你总是可以到达数组的最后一个位置。
示例 1:
输入: nums = [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO45JumpGameII {
    public static int jump(int[] nums) {

        int n=nums.length;
        if(n==1)return 1;
        int index=1;
        int cover=nums[0];

        for(int i=0;i<=cover;++i){
//可能第一跳就可以跳到终点
            if(cover>=n-1)return index;
            cover=search(cover,nums);
            ++index;

        }
        return index;
    }
//每次找最大一跳
    private static int search(int cover,int[] nums) {
        int t=cover;
        for(int i=0;i<=cover; ++i){
            t=Math.max(t,nums[i]+i);
        }
        return t;
    }
    public int jump1(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {//扩大终点
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] a={2,3,1,1,4};
        System.out.println(jump(a));
    }
}
