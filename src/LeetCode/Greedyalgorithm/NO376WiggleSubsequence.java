package LeetCode.Greedyalgorithm;
/*
如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
    例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
    相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
示例 1：
输入：nums = [1,7,4,9,2,5]
输出：6
解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/wiggle-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO376WiggleSubsequence {
    public static int wiggleMaxLength(int[] nums) {


        int length=0;
        int M_length=0;
        int n=nums.length;
        if(n<=2)return n;
        int sub=nums[1]-nums[0];
        int sub1=sub;
        for (int i=2;i<n;++i){
            sub1=sub;
            sub=nums[i]-nums[i-1];
            if(sub*sub1<0)++length;
            else {
                M_length=Math.max(M_length,length);
                length=0;

            }
            System.out.println("sub1  "+sub1+"   sub"+sub);
        }
        M_length=Math.max(M_length,length);
        return M_length;
    }

    public static void main(String[] args) {
        int[] a={1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(a));
    }
}