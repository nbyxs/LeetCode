package LeetCode.twopoints;

public class NO1658 {
    //找最短将x减为0的次数（每次减去的是最左或最右的数）即找最长连续子数组使得和为sum-x
    public  static int minOperations(int[] nums, int x) {
        int target=0;
        int left=0;
        int right=0;
        int n=nums.length;
        int sum=0;
        int len=-1;
        for(int m:nums)sum+=m;
        if(sum<x)return -1;
        while (right<n){
            target+=nums[right];
            while (target>sum-x){
                target-=nums[left++];

            }
            if(target==sum-x){
                len=Math.max(right-left+1,len);}
            ++right;
        }
        return len==-1?len:n-len;

    }

    public static void main(String[] args) {
        int[] a={3,2};
        System.out.println(minOperations(a,5));
    }
}
