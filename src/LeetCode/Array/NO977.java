package LeetCode.Array;

public class NO977 {
    public static int[] sortedSquares(int[] nums) {
        int l=0;
        int r=nums.length-1;
        while (l<=r){
            nums[l]=Math.abs(nums[l]);
            nums[r]=Math.abs(nums[r]);
            if(nums[l]>=nums[r]){
                int t=nums[l];
                nums[l]=nums[r];
                nums[r]=t;
                --r;
            }
            ++l;
        }
        for(int n:nums) System.out.print(n+" ");
        return nums;

    }

    public static void main(String[] args) {
        int[] a={-4,-1,0,3,10};
        sortedSquares(a);
    }

}
