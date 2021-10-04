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
    //力扣提交要将去除static修饰符
    private static List<List<Integer>> res=new ArrayList<>();
   private static List<Integer> list=new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {

        search_review(1,n,k);
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
    private static void search_review(int index, int n, int k){
        if(list.size()+(n-index+1)<k)return;
       //先将list加入res再判断index和n的大小，否则当index=5时，此时以4结尾的list都不能加入结果集
        /*
           if(index>n)return;
           if(list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }
         */
        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }

        if(index>n)return;
        list.add(index);
        //将index加入队列
        search_review(index+1,n,k);
        list.remove(list.size()-1);
        //不将index加入队列
        search_review(index+1,n,k);
    }


    public static void main(String[] args) {
        combine(4,2);
        System.out.println("+++++++++++++++++++++++++");
        for(List<Integer> res:res) System.out.println(res.toString());
    }
}
