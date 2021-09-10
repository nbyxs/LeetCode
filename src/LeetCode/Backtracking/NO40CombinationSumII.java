package LeetCode.Backtracking;
/*
给定一个数组 candidates 和一个目标数 target ，
找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。
注意：解集不能包含重复的组合。
示例 1:
输入: candidates = [10,1,2,7,6,1,5], target = 8,
输出:
[[1,1,6],[1,2,5],[1,7],[2,6]]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NO40CombinationSumII {



    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
       if(candidates.length==0)return  res;
       Arrays.sort(candidates);
       List<Integer> list=new ArrayList<>();
       dfs(res,list,candidates,target,0);
       return  res;
    }

    private static void dfs(List<List<Integer>> res,List<Integer> list, int[] candidates, int target, int begin) {
        if(target==0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=begin;i<candidates.length;++i){
            if(i>begin&&candidates[i]==candidates[i-1])continue;
            if(target-candidates[i]>=0){
                list.add(candidates[i]);
                dfs(res,list,candidates,target-candidates[i],i+1);
                list.remove(list.size()-1);
            }
        }
    }

    public static List<List<Integer>> combinationSum21(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length==0)return  res;
        Arrays.sort(candidates);
        List<Integer> list=new ArrayList<>();
        dfs1(res,list,candidates,target,0);
        return  res;
    }
    private static void dfs1(List<List<Integer>> res,List<Integer> list, int[] candidates, int target, int begin){
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(begin>=candidates.length)return;
        for(int i=begin;i<candidates.length;++i){
            if(i>begin&&candidates[i]==candidates[i-1])continue;
            if(target-candidates[i]>=0){
                list.add(candidates[i]);
                dfs(res,list,candidates,target-candidates[i],i+1);
                list.remove(list.size()-1);
            }
        }

    }
    public static void main(String[] args) {
        int[] a={2,5,2,1,2};
        int target=5;
        List<List<Integer>> res=combinationSum2(a,target);
        for(List<Integer> list:res) System.out.println(list.toString());
        System.out.println("++++++++++++++++");
        List<List<Integer>> res1=combinationSum21(a,target);
        for(List<Integer> list:res1) System.out.println(list.toString());
    }
}
