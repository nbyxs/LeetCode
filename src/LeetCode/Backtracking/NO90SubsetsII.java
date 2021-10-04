package LeetCode.Backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
示例 1：
输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
思路：若发现没有选择上一个数，且当前数字与上一个数相同，则可以跳过当前生成的子集。
 */
public class NO90SubsetsII {
   static List<List<Integer>> res=new ArrayList<List<Integer>>();
    static List<Integer> list=new ArrayList<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        dfs_review(false, 0, nums);
        return res;
    }

    public static void dfs(boolean choosePre, int cur, int[] nums) {
        if (cur == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        dfs(false, cur + 1, nums);
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        list.add(nums[cur]);
        dfs(true, cur + 1, nums);
        list.remove(list.size() - 1);
    }
    public static void dfs_review(boolean choosePre, int cur, int[] nums){
        if(cur==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        dfs_review(false,cur+1,nums);
        //树层去重，如果两个相同的元素前一个没选就选前一个
        if(!choosePre&&cur>0&&nums[cur-1]==nums[cur])return;
        list.add(nums[cur]);
        dfs_review(true,cur+1,nums);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        int[] a={1,2,2};
        System.out.println(a.toString());
        List<List<Integer>> res=subsetsWithDup(a);
        for(List<Integer> list:res) System.out.println(list.toString());
    }

}
