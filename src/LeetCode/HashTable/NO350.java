package LeetCode.HashTable;

import java.util.*;

public class NO350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map_1=new HashMap<>();
        HashMap<Integer,Integer> map_2=new HashMap<>();
        int[] list=new int[Math.min(nums1.length,nums2.length)];
        int count=0;
        for (int value : nums1) map_1.put(value, map_1.getOrDefault(value, 0) + 1);
        for (int value : nums2) map_2.put(value, map_2.getOrDefault(value, 0) + 1);
        for(Map.Entry<Integer,Integer> map:map_1.entrySet()){
            int key=map.getKey();
            int value=map.getValue();
            if(map_2.containsKey(key)){
                value=Math.min(value,map_2.get(key));
                while (value>0){
                   --value;
                   list[count++]=key;
                }
            }
        }
        return Arrays.copyOfRange(list,0,count);


    }
}
