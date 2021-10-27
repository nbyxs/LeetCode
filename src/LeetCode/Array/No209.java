package LeetCode.Array;

public class No209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int l=0;
        int r=0;
        int res=Integer.MAX_VALUE;
        int sum=0;
        while(r<n){
            sum+=nums[r];
            while (sum>=target){

                res=Math.min(res,r-l+1);
                sum-=nums[l];
                ++l;
            }
            ++r;
        }
return res==Integer.MAX_VALUE?-1:res;
    }

    public static void main(String[] args) {

    }
}
