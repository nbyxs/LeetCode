package LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
示例 1：
输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
0/1序列 子集 对应二进制数
000     {}      0
001     {3}     1
010     {2}     2
011     {2,3}   3
100     {1}     4
101     {1,3}   5
110     {1,2}   6
111     {1,2,3} 7
 */
public class NO78Subsets {
   static List<List<Integer>> res=new ArrayList<>();
   static List<Integer> t=new ArrayList<>();
   private static int n=0;
    public static List<List<Integer>> subsets(int[] nums) {

        n=nums.length;
      for(int l=0;l<(1<<n);++l){//控制位数从一位扩展到2^n-1位
          t.clear();
          for(int i=0;i<n;++i){
              if((l&(1<<i))!=0)//在已扩展的位数上一一判断是否为1，为1就将对应位的值放入临时数组
                  t.add(nums[i]);
          }
          res.add(new ArrayList<>(t));
      }
      return res;
    }
    public static List<List<Integer>> subsets_review(int[] nums){
        n=nums.length;
        for(int i=0;i<(1<<n);++i){
            t.clear();
            for(int j=0;j<n;++j){
                if((i&(1<<j))!=0)t.add(nums[j]);
            }
            res.add(new ArrayList<>(t));
        }
        return res;
    }


        public static List<List<Integer>> subsets1(int[] nums) {
            recur(nums,new ArrayList<>(),0);
            return res;
        }
        public static void recur(int[] nums, List<Integer> list, int n){
            res.add(new ArrayList<>(list));
            if(nums.length==n) return;

            for (int i = n; i < nums.length; i++) {
                list.add(nums[i]);
                recur(nums,list,i+1);
                list.remove(list.size()-1);

            }

        }


    public static void main(String[] args) {
        List<List<Integer>> res=subsets_review(new int[]{1,2,3});
        for(List<Integer> list:res) System.out.println(list.toString());

    }
}
