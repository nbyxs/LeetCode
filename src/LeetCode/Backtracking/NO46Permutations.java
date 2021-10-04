package LeetCode.Backtracking;
/*
全排列
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NO46Permutations {

    static boolean[] str=null;
    static  int n=0;
    static List<Integer> list = new ArrayList<Integer>();
    static List<List<Integer>> res = new ArrayList<List<Integer>>();
    public static List<List<Integer>> permute(int[] nums){

        n=nums.length;
        str=new boolean[n];
        dfs(0,nums);
        return res;
    }

    private static void dfs(int index,int[] nums) {
        if(index==n){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;++i){
            if(!str[i]){
                str[i]=true;
                list.add(nums[i]);
                dfs(index+1,nums);
                str[i]=false;
                list.remove(list.size()-1);
            }
        }
    }


    public static void main(String[] args) {
        int[] a={1,2,3,4};
        List<List<Integer>> list=permute(a);
        for(List<Integer> list1:list) System.out.println(list1.toString());
        System.out.println(list.size());

    }
}

