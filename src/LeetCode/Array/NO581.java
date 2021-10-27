package LeetCode.Array;

public class NO581 {
    public static int findUnsortedSubarray(int[] nums) {

       int l=0;
       int r=0;
       boolean flag_l=false;
       boolean flag_r=false;
       int n=nums.length;
       for(int i=0;i<n-1;++i){
           if(nums[i+1]<nums[i]){
               l=i;
               flag_l=true;
               break;
           }
       }
       for(int i=n-1;i>=1;--i){
           if(nums[i]<nums[i-1]){
               r=i;
               flag_r=true;
               break;
           }
           else  if(flag_l&&nums[i]<nums[l]){
               r=i;
               flag_r=true;
               break;
           }
       }
        System.out.println(l+" "+r);
       if(!flag_l&&!flag_r)return 0;
       return r-l+1;
    }

    public static void main(String[] args) {
        int[] a={2,3,3,2,4};
        System.out.println(findUnsortedSubarray(a));
    }
}
