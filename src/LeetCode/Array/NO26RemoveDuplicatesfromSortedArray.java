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

        int low=0;
        int fast=0;
        int n=nums.length;
        while(low<n&&fast<n){
            int fast0=fast;
            while (fast0<n&&nums[fast]==nums[fast0])++fast0;
            fast=fast0;
//            int low0=low;
//            while(low0<n&&nums[low0]!=nums[low])++low0;
//            low=low0;
            int temp=nums[fast-1];
            nums[fast-1]=nums[low];
            nums[low++]=temp;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] array={0,0,1,1,1,2,2,3,3,4};
        int length=removeDuplicates1(array);
        //System.out.println();
        for(int i=0;i<length;i++) System.out.print(array[i]+" ");

    }
}
