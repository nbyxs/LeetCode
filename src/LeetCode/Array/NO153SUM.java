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
      int n=nums.length;

        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        if(n<=2) return res;
      Arrays.sort(nums);
      for(int i=0;i<n;++i){
          if(i>0&&nums[i-1]==nums[i])continue;

          for(int j=i+1,k=n-1;j<n;++j){
              if(j>i+1&&nums[j-1]==nums[j])continue;
              while (k>j&&nums[k]+nums[i]+nums[j]>0)--k;
              if(j==k)break;
              if(nums[i]+nums[j]+nums[k]==0){
                  list.add(nums[i]);
                  list.add(nums[j]);
                  list.add(nums[k]);
                  res.add(new ArrayList<>(list));
                  list.clear();
              }
          }
      }
      return res;
    }

            public List<List<Integer>> threeSum_better(int[] nums) {
                List<List<Integer>> results = new ArrayList<>();
                Arrays.sort(nums);
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] > 0) {
                        break;
                    }
                    if (i > 0 && nums[i] == nums[i - 1]) {
                        continue;
                    }
                    int left = i + 1;
                    int right = nums.length - 1;
                    int target = 0 - nums[i];
                    while (left < right) {
                        if (nums[left] + nums[right] > target) {
                            right--;
                        } else if (nums[left] + nums[right] < target) {
                            left++;
                        } else {
                            List<Integer> result = new ArrayList<>();
                            result.add(nums[i]);
                            result.add(nums[right]);
                            result.add(nums[left]);
                            results.add(result);

                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            //退出循环的条件是nums[left]!=nums[left+1] 所以left要从left+1开始
                            while (left < right && nums[right - 1] == nums[right]) {
                                right--;
                            }

                            left++;
                            right--;
                        }
                    }
                }
                return results;
            }


    public static void main(String[] args) {

        int[] a={1,2,-2,-1};
        List<List<Integer>> res1=threeSum(a);
        List<List<Integer>> res2=threeSum1(a);
        for(List<Integer> list:res1) System.out.println(list.toString());
        System.out.println("++++++++++++++++++++++");
        for(List<Integer> list:res2) System.out.println(list.toString());
    }
        }
