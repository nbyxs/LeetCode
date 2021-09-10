package LeetCode.Array;
/*
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
假定每组输入只存在唯一答案。
示例：
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
import java.util.Arrays;

public class NO163SumClosest {
    public static int threeSumClosest(int[] nums, int target) {

      Arrays.sort(nums);
      int ans=10000;
      int n=nums.length;
      for(int i=0;i<n;++i){
          int j=i+1;
          int k=n-1;
          while(j<k){
              int sum=nums[i]+nums[j]+nums[k];
              if(sum==target)return  target;
              if(Math.abs(sum-target)<Math.abs(ans-target))ans=sum;
              if(sum>target){
                  int k0=k-1;
                  while(j<k0&&nums[k0]==nums[k])--k0;
                  k=k0;
              }
              if(sum<target){
                  int j0=j+1;
                  while (j0<k&&nums[j0]==nums[j])++j0;
                  j=j0;
              }
          }
      }return ans;
}
    public static int threeSumClosest1(int[] nums, int target) {
        int n=nums.length;
        int res=100000;
        for(int i=0;i<n;++i){
            int j=i+1;
            int k=n-1;
            while (j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==target)return sum;
                if(Math.abs(target-sum)<Math.abs(target-res))res=sum;
                //if-else 将sum逼近target
                if(sum>target){
                    int k0=k-1;
                    while(j<k0&&nums[k]==nums[k0])--k0;
                    k=k0;
                }
                else {
                    int j0=j+1;
                    while (j0<k&&nums[j0]==nums[j])++j0;
                    j=j0;
                }
            }
        }return res;
    }
    public static void main(String[] args) {
        int[] arrays= new int[]{0,2,1,-3};
        int target=1;
        System.out.println(threeSumClosest(arrays,target));
        System.out.println(threeSumClosest1(arrays,target));
    }
}
