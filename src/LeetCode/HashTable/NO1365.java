package LeetCode.HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NO1365 {
    public  static int[] smallerNumbersThanCurrent(int[] nums) {


        int n=nums.length;
        int[] res=new int[n];
        int[] ans=new int[n];
        HashMap<Integer,Integer> map=new HashMap<>();
       int[] b= Arrays.copyOfRange(nums,0,n);
        for(int i=0;i<n;++i){
            map.put(i,nums[i]);

        }

        Arrays.sort(nums);
        for(int i=1;i<n;++i){
           int sameNumber=1;
           while(nums[i-1]==nums[i]&&i<n){
               ++sameNumber;

               res[i]=res[i-1];
               ++i;
           }
           if(i<n){
               if(nums[i-1]<nums[i]){
                   res[i]+=(res[i-1]+sameNumber);
               }
           }

        }
       for(Map.Entry<Integer,Integer> m:map.entrySet()){
           ans[m.getKey()]=res[binarySearch(0,n,m.getValue(),nums)];
       }
        return ans;
    }
    //左闭右开
public  static  int binarySearch(int l,int r,int target,int[] nums){

        while (l<r){
            int mid=l+r >>1;
            if(target<nums[mid]){
                r=mid;
            }
            else if(target>nums[mid]){
                l=mid+1;
            }
            else return  mid;
        }
        return l;

}
    public int[] smallerNumbersThanCurrent1(int[] nums) {
        int[] cnt = new int[101];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        for (int i = 1; i <= 100; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] a={8,1,2,2,3};

        int[] res=smallerNumbersThanCurrent(a);
        for(int num:res) System.out.print(num+" ");
    }
}
