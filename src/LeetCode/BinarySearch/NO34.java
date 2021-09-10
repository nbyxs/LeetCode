package LeetCode.BinarySearch;
/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。
示例 1：
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
 */
public class NO34 {
    public static int[] searchRange(int[] nums, int target) {
        System.out.println(searchfirst(nums,target)+searchlast(nums,target));
        return new int[]{searchfirst(nums,target),searchlast(nums,target)};
    }

    private static int searchfirst(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        int mid=0;
        while(l<=r){
             mid=(l+r)>>1;
            if(nums[mid]>target)r=mid-1;
            else if(nums[mid]<target)l=mid+1;
            else{
                if(mid==0||nums[mid-1]!=target)return mid;
            }
            r=mid-1;
        }
        return -1;
    }
    private static int searchlast(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        int mid=0;
        while(l<=r){
            mid=(l+r)>>1;
            if(nums[mid]>target)r=mid-1;
            else if(nums[mid]<target)l=mid+1;
            else{
                if(mid==nums.length-1||nums[mid+1]!=target)return mid;
            }
            l=mid+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a={5,7,7,8,8,10};
        int target=8;
        int[] b=searchRange(a,target);
        for(int i=0;i<b.length;++i) System.out.println(b[i]);
    }
}
