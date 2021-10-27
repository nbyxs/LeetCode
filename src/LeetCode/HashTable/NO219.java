package LeetCode.HashTable;

import java.util.HashMap;

public class NO219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;++i){

            if(map.containsKey(nums[i])){
                if((i-map.get(nums[i])<=k))return true;

            }
            map.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,1};
        System.out.println(containsNearbyDuplicate(a,3));
    }
}
