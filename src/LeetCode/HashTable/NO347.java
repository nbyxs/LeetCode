package LeetCode.HashTable;

import java.util.*;

public class NO347 {
    public static int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        if(n<=k)return nums;
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] res=new int[k];
        for(int num:nums)map.put(num,map.getOrDefault(num,0)+1);
        PriorityQueue<Map.Entry<Integer,Integer>> queue=new PriorityQueue<>((m1,m2)->(m2.getValue()-m1.getValue()));
        queue.addAll(map.entrySet());
        for(int i=0;i<k;++i){

            res[i]= Objects.requireNonNull(queue.poll()).getKey();
        }
return res;
    }

    public static void main(String[] args) {
        int[] a={1,1,1,2,2,3};
        int k=2;
        int[] b=topKFrequent(a,k);
        for(int n:b) System.out.print(n+" ");
    }
}
