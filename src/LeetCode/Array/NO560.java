package LeetCode.Array;

import java.util.HashMap;

public class NO560 {
   public static int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
       for (int num : nums) {
           pre += num;
           if (mp.containsKey(pre - k)) {
               count += mp.get(pre - k);
           }
           mp.put(pre, mp.getOrDefault(pre, 0) + 1);
       }
        return count;
    }



    public static void main(String[] args) {
        int[] a={1,1,1};
        System.out.println(subarraySum(a,2));
    }
}
