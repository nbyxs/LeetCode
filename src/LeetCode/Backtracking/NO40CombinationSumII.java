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

    private static List<List<Integer>> res=new ArrayList<List<Integer>>();
    private static List<Integer> list=new ArrayList<>();
    private  static  int n=0;
    public static List<List<Integer>> combinationSum(int[] a, int target) {
        n=a.length;
        Arrays.sort(a);
      dfs(a,target,0);
      return res;
    }

    private static void dfs(int[] a, int target, int index) {
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(index>=n)return;

        for(int i=index;i<n;++i){
            if(i>index&&a[i]==a[i-1])continue;
            if(target-a[i]>=0){
                list.add(a[i]);
                dfs(a,target-a[i],i+1);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a={2,5,2,1,2};
        int target=5;
        List<List<Integer>> res=combinationSum(a,target);
        for(List<Integer> list:res) System.out.println(list.toString());


    }


}
