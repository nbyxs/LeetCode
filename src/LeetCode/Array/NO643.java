package LeetCode.Array;

public class NO643 {
    public static double findMaxAverage(int[] nums, int k) {

    int n=nums.length;
    if(n==1)return (double)nums[0];
    double ans=-1000000.0;
    int sum=0;
    for(int i=0;i<n;++i){

        sum+=nums[i];
        if(i>=k-1){
            ans=Math.max(ans,sum/1.0/k);
            sum-=nums[i-k+1];
        }


    }
    return ans;
}

    public static void main(String[] args) {
        int[] a={1,12,-5,-6};
        System.out.println(findMaxAverage(a,4));
    }
}
