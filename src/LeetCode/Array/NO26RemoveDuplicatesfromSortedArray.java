package LeetCode.Array;
/*
给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
示例 1：
输入：nums = [1,1,2]
输出：2, nums = [1,2]
解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。

 */
import java.util.Arrays;

public class NO26RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] nums) {

        int n=nums.length;
        int length=0;
        for(int i=0;i<n;){
            int i0=i;
            while(i0<n&&nums[i0]==nums[i]){
                ++i0;

            }
           // nums[i]
            System.out.println(i);

            //System.out.println(i);

            i=i0;
           nums[length++]=nums[i0-1];
        }
        return  length;
    }
    public static int removeDuplicates1(int[] nums){
        int n=nums.length;
        if(n<=1)return n;
        int index=1;
        int l=1;
        while (l<n){
            while (l<n&&nums[index-1]==nums[l])++l;
            if(nums[index-1]!=nums[l]){
                nums[index++]=nums[l++];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array={};
        int length=removeDuplicates1(array);
        //System.out.println();
        for(int i=0;i<length;i++) System.out.print(array[i]+" ");

    }
}
