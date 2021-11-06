package LeetCode.Array;
/*
给你一个包含 n 个整数的数组 nums，
判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
请你找出所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。
示例 1：
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
*/
import java.util.*;

public class NO153SUM {
    public static List<List<Integer>> threeSum(int[] nums) {

              int n=nums.length;
              Arrays.sort(nums);
              List<List<Integer>> ans=new ArrayList<List<Integer>>();
              for(int i=0;i<n;++i){
                  if(i>0&&nums[i]==nums[i-1])continue;
                  for(int j=i+1,k=n-1;j<n;++j){
                      if(j>i+1&&nums[j]==nums[j-1])continue;
                      while(j<k&&nums[i]+nums[j]+nums[k]>0)--k;
                      if(j==k)break;
                      if(nums[i]+nums[j]+nums[k]==0) {
                          List<Integer> list=new ArrayList<>();
                          list.add(nums[i]);
                          list.add(nums[j]);
                         list.add(nums[k]);
                         ans.add(list);
                      }
                  }
              }
              return ans;
            }
    public static List<List<Integer>> threeSum1(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();

        int n=nums.length;
        if(n<3)return res;
        for(int i=0;i<n;++i) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            for (int j = i + 1, k = n - 1; j < n; ++j) {
                if (j > i + 1 && nums[j - 1] == nums[j]) continue;


                while (k > j && nums[i] + nums[j] + nums[k] > 0) --k;
                if(k==j)break;


                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        res.add(new ArrayList<>(list));


                }
            }
        }
        return res;
    }


    public static void main(String[] args) {

        int[] a={-1,0,1,2,-1,-4};
        List<List<Integer>> res1=threeSum(a);
        List<List<Integer>> res2=threeSum1(a);
        for(List<Integer> list:res1) System.out.println(list.toString());
        System.out.println("++++++++++++++++++++++");
        for(List<Integer> list:res2) System.out.println(list.toString());
    }
        }
