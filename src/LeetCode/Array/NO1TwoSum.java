package LeetCode.Array;
/*
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。
示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NO1TwoSum {
    public int[]  twoSum(int[] nums, int target) {
       HashMap<Integer,Integer> hashMap=new HashMap<>();
       for(int i=0;i< nums.length;++i){
           //if(hashMap.get(target-nums[i])!=null)
           if(hashMap.containsKey(target-nums[i]))
               return new int[]{hashMap.get(target-nums[i]),i};
           hashMap.put(nums[i],i);
       }
       return  new int[0];

    }
    public static int[]  twoSum1(int[] nums, int target){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;++i){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a={2,7,11,15};
        int target=9;
        int[] b=twoSum1(a,target);
        for(int i=0;i<b.length;++i) System.out.print(b[i]+" ");
    }
}
