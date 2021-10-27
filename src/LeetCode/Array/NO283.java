package LeetCode.Array;

import java.util.Arrays;

public class NO283 {
    public static void moveZeroes(int[] nums) {

        int n = nums.length;
        int index= 0;
        for (int i = 0; i < n; ++i) {
            if(nums[i]!=0)nums[index++]=nums[i];

        }
        Arrays.fill(nums,index,n,0);
        for(int num:nums) System.out.print(num+" ");
    }
    public static void moveZeroes_double(int[] nums) {

        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
               int t=nums[right];
               nums[right]=nums[left];
               nums[left]=t;
                ++left;
            }
            ++right;
        }


    }

    public static void main(String[] args) {
        int[] a={0,1,0,3,12};
        moveZeroes(a);
    }
}
