package LeetCode.Sort;

public class NO912 {
   static int[] temp;
    public static int[] sortArray(int[] nums) {
       // temp=new int[nums.length];
        for(int i=nums.length/2;i>=0;--i)Sort_heap(nums,i);
        return nums;

    }
    private static void Sort_quick(int[] nums, int l, int r) {
        if(l>=r)return;
        int i=l-1;
        int j=r+1;
        int x=nums[l+r >>1];
        while (i<j){
            do i++;while (nums[i]<x);
            do j--;while (nums[j]>x);
            if(i<j){
                int t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
            }
        }
        Sort_quick(nums,l,j);
        Sort_quick(nums,j+1,r);
    }
    private static void Sort_merge(int[] nums, int l, int r){
        if(l>=r)return;
        int mid=l+r >>1;
        Sort_merge(nums,l,mid);
        Sort_merge(nums,mid+1,r);
        int i=l;
        int j=mid+1;
        int t=0;
        while (i<=mid&&j<=r){
            if(nums[i]<nums[j])temp[t++]=nums[i++];
            else temp[t++]=nums[j++];
        }
        while(i<=mid)temp[t++]=nums[i++];
        while(j<=r)temp[t++]=nums[j++];
        for(int i11=l,j1=0;i11<=r;++i11,++j1)nums[i11]=temp[j1];

    }
    private static void Sort_heap(int[] nums,int x){
        int n=nums.length-1;
        int t=x;
        if(2*x<=n&&nums[t]>nums[2*x]){
            t=2*x;
        }
        if(2*x+1<=n&&nums[t]>nums[2*x+1]){
            t=2*x+1;
        }

        if(t!=x){
            int temp=nums[t];
            nums[t]=nums[x];
            nums[x]=temp;
            Sort_heap(nums,t);
        }
    }

    public static void main(String[] args) {
        int[] a={5,1,1,2,0,0};
       int[] b= sortArray(a);
       for(int b1:b) System.out.print(b1+" ");
    }
}
