package LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;
/*
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
你可以按 任何顺序 返回答案。
输入：n = 4, k = 2
输出：[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4],]
 */

public class NO77Combinations {
    private static List<List<Integer>> res=new ArrayList<>();
   private static List<Integer> list=new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {

        search(1,n,k);
        return  res;
    }

    private static void search(int index, int n, int k) {
        if(list.size()+(n-index+1)<k)return;
        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }
        if(index==n+1)return;
        list.add(index);
        search(index+1,n,k);
        list.remove(list.size()-1);
        search(index+1,n,k);
    }


    public static void main(String[] args) {
        combine(4,2);
        System.out.println("+++++++++++++++++++++++++");
        for(List<Integer> res:res) System.out.println(res.toString());
    }
}
