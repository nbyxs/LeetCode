package LeetCode.CodingOffer;
/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

示例：

输入：nums = [1,2,3,4]
输出：[1,3,2,4]
注：[3,1,2,4] 也是正确的答案之一。
 */
public class Offer21 {
    public static int[] exchange(int[] nums) {

        int l=0;
        int r=nums.length-1;
        while(l<r){
            while(((nums[l]&1)==1)&&l<r)++l;
            while (((nums[r]&1)==0)&&l<r)--r;
            if(l<r){
                int t=nums[l];
                nums[l]=nums[r];
                nums[r]=t;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a={1,3,5};
        exchange(a);
        for(int i=0;i<a.length;++i) System.out.print(a[i]+" ");
    }
}
