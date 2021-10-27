package LeetCode.Sort;

public class NO75 {
    public static void sortColors(int[] nums) {
        int l=0;
        int r=nums.length-1;
        if(r<=1)return;
        for(int i=0;i<=r;++i){
            if(nums[i]==0){
                int t=nums[l];
                nums[l]=nums[i];
                nums[i]=t;
                ++l;
            }
            if(nums[i]==2){
                int t=nums[r];
                nums[r]=nums[i];
                nums[i]=t;
                --r;
            }
            if(nums[i]!=1)--i;
        }

    }

    public static void main(String[] args) {
        int[] a={};

    }
}
