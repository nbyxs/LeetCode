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
import java.util.Arrays;
import java.util.List;

public class NO39CombinationSum {
   private static List<List<Integer>> res=new ArrayList<List<Integer>>();
   private static List<Integer> list=new ArrayList<>();
 private  static  int n=0;
    private static List<List<Integer>> combinationSum(int[] a, int target) {
        n=a.length;

        dfs(a,0,target);
        return res;
    }

    private static void dfs(int[] a,int l,int target) {



        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }

        if(l>=n)return;
      if(target-a[l]>=0){  list.add(a[l]);
       dfs(a,l,target-a[l]);
       list.remove(list.size()-1);
      }
       dfs(a,l+1,target);
    }

    public static void main(String[] args) {
        int[] a={2,3,5};
        int target=8;
        List<List<Integer>> res=combinationSum(a,target);
        for(List<Integer> list:res) System.out.println(list.toString());
    }


}
