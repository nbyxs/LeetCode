package LeetCode.TwoPoints;

import java.util.Arrays;
import java.util.Collections;

/**
 * 首先从后向前查找第一个顺序对 (i,i+1)，满足 a[i]<a[i+1]。这样「较小数」即为 a[i]。此时 [i+1,n)必然是下降序列。
 *
 * 如果找到了顺序对，那么在区间 [i+1,n)中从后向前查找第一个元素 j满足 a[i]<a[j]。这样「较大数」即为 a[j]。
 *
 * 交换 a[i]与a[j]，此时可以证明区间 [i+1,n) 必为降序。我们可以直接使用双指针反转区间 [i+1,n) 使其变为升序，而无需对该区间进行排序。

 */
public class NO31 {
    public static void nextPermutation(int[] nums) {
        int n=nums.length;
        if(n<=1)return;
        int index_last_min=-1;
        int index_last_max=0;
        //步骤1
        for(int i=n-1;i>0;--i){
            if(nums[i]>nums[i-1]){
                index_last_min=i-1;
                break;
            }
        }
        System.out.println(index_last_min);
        if(index_last_min==-1){
            reverse(nums,0,n-1);
            return;
        }
        //步骤2
        for(int i=n-1;i>index_last_min;--i){
            if(nums[i]>nums[index_last_min]){
                index_last_max=i;
                break;
            }
        }
        int t=nums[index_last_min];
        nums[index_last_min]=nums[index_last_max];
        nums[index_last_max]=t;

        System.out.println(index_last_max);
        reverse(nums,index_last_min+1,n-1);


    }
//步骤3
    private static void reverse(int[] nums, int left, int right) {
        while (left<right){
            int t=nums[left];
            nums[left]=nums[right];
            nums[right]=t;
            ++left;
            --right;
        }
    }

    public static void main(String[] args) {
        int[] a={3,2,1};
        nextPermutation(a);
        for(int n:a) System.out.print(n+" ");

    }
}
