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

    public static List<List<Integer>> permute(int[] nums) {
        Boolean[] str=new Boolean[nums.length];
        for (int i=0;i< nums.length;++i)str[i]=false;
        List<List<Integer>> res=new ArrayList<>();
       List<Integer> list=new ArrayList<>();
        permute1(res,nums,str,list,0);
     return  res;
    }

    private static void permute1(List<List<Integer>> res, int[] nums, Boolean[] str, List<Integer> list, int index) {
       if(index>=nums.length){
           System.out.println(list.toString());
           res.add(new ArrayList<Integer>(list));
           return;
       }
       for(int i=0;i<nums.length;++i){
           if(!str[i]){
               list.add(nums[i]);
               str[i]=true;
               permute1(res,nums,str,list,index+1);
               str[i]=false;
               list.remove(index);

           }
       }

    }
    public static List<List<Integer>> permute1(int[] nums){
        Boolean[] str=new Boolean[nums.length];
        for (int i=0;i< nums.length;++i)str[i]=false;
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        permute11(res,nums,str,list,0);
        return  res;
    }
    private static void permute11(List<List<Integer>> res, int[] nums, Boolean[] str, List<Integer> list, int index){
        if(index==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;++i){
            if(!str[i]){
                str[i]=true;
                list.add(nums[i]);
                permute11(res,nums,str,list,index+1);
                str[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        int[] a={1,2,3,4};
        List<List<Integer>> list=permute1(a);
        for(List<Integer> list1:list) System.out.println(list1.toString());
        System.out.println(list.size());

    }
}

