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
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        Boolean[] str=new Boolean[nums.length];
        for (int i=0;i< nums.length;++i)str[i]=false;
       List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        permute11(res,nums,str,list,0);
        return res;
    }

    private static void permute1(List<List<Integer>> res, int[] nums, Boolean[] str, List<Integer> list, int index) {
        if(index>=nums.length){
            //System.out.println(list.toString());
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;++i){
            /*
            限制一下两个相邻的重复数字的访问顺序
            举个栗子，对于两个相同的数11，我们将其命名为1a1b, 1a表示第一个1，1b表示第二个1；
            那么，不做去重的话，会有两种重复排列 1a1b, 1b1a， 我们只需要取其中任意一种排列；
            为了达到这个目的，限制一下1a, 1b访问顺序即可。
            比如我们只取1a1b那个排列的话，只有当visit nums[i-1]之后我们才去visit nums[i]，
            也就是如果!visited[i-1]的话则continue
             */
           if(str[i]||(i>0&&nums[i]==nums[i-1]&&!str[i-1]))continue;//每次填入的数一定是这个数所在重复数集合中「从左往右第一个未被填过的数字」

            //即将第i个数加入的前提是第i-1个数已经在集合中
                list.add(nums[i]);
                str[i]=true;
                permute1(res,nums,str,list,index+1);
                str[i]=false;
                list.remove(index);


        }
}
    private static void permute11(List<List<Integer>> res, int[] nums, Boolean[] str, List<Integer> list, int index){
        if(index==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.length;++i){
            if(str[i]||(i>0&&nums[i-1]==nums[i]&&!str[i-1]))continue;
                str[i]=true;
                list.add(nums[i]);
                permute11(res,nums,str,list,index+1);
                list.remove(list.size()-1);
                str[i]=false;

        }
    }
    public static void main(String[] args) {
        int[] a={1,1,2};
        List<List<Integer>> list=permuteUnique(a);
        for(List<Integer> list1:list) System.out.println(list1.toString());
        System.out.println(list.size());



    }
}
