package LeetCode.Backtracking;
/*
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
示例 1：
输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]

 */
import java.util.*;

public class NO47PermutationsII {
    static boolean[] str=null;
    static  int n=0;
    static List<Integer> list = new ArrayList<Integer>();
    static List<List<Integer>> res = new ArrayList<List<Integer>>();
    public static List<List<Integer>> permuteUnique(int[] nums){
        n=nums.length;
        str=new boolean[n];
        Arrays.sort(nums);
        dfs(0,nums);
        return res;
    }

    private static void dfs(int count, int[] nums) {
        if(count==n){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;++i){
            if (i>0&&nums[i-1]==nums[i]&&!str[i-1])continue;
            if(!str[i]){
                str[i]=true;
                list.add(nums[i]);
                dfs(count+1,nums);
                str[i]=false;
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a={1,1,2};
        List<List<Integer>> list=permuteUnique(a);
        for(List<Integer> list1:list) System.out.println(list1.toString());
        System.out.println(list.size());



    }
}
