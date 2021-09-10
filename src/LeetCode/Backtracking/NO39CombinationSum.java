package LeetCode.Backtracking;
/*
给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，
找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。

candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。

对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
示例 1：
输入: candidates = [2,3,6,7], target = 7
输出: [[7],[2,2,3]]

 */
import java.util.ArrayList;
import java.util.List;

public class NO39CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<>();
        if(candidates.length==0)return  res;
        dfs(res,list,0,target,candidates);
        return  res;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> list, int index, int target, int[] candidates) {
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(index>=candidates.length)return;
        dfs(res,list,index+1,target,candidates);
        if(target-candidates[index]>=0){
            list.add(candidates[index]);
            dfs(res,list,index,target-candidates[index],candidates);
            list.remove(list.size()-1);
        }
    }
    public static List<List<Integer>> combinationSum1(int[] candidates, int target){
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<>();
        if(candidates.length==0)return  res;
        dfs1(res,list,0,target,candidates);
        return  res;
    }
    private static void dfs1(List<List<Integer>> res, List<Integer> list, int index, int target, int[] candidates){
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(index>=candidates.length)return;
        if(target-candidates[index]>=0){
            list.add(candidates[index]);
              dfs1(res,list,index,target-candidates[index],candidates);
              list.remove(list.size()-1);
        }
        dfs1(res,list,index+1,target,candidates);

    }
    public static void main(String[] args) {
        int[] a={2,3,5};
        int target=8;
        List<List<Integer>> res=combinationSum1(a,target);
        for(List<Integer> list:res) System.out.println(list.toString());
    }
}
