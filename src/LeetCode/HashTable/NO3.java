package LeetCode.HashTable;

import java.util.HashMap;
import java.util.Map;

public class NO3 {
    public  static int lengthOfLongestSubstring(String s) {
        char[] list=s.toCharArray();
       HashMap<Character,Integer> map=new HashMap<>();
       int n=list.length;
       if(n<=1)return n;
       int start=0;
       int res=1;
       for(int end=0;end<n;++end){
           if(map.containsKey(list[end])){
               start=Math.max(start,map.get(list[end])+1);
           }
           res=Math.max(res,end-start+1);
           map.put(list[end],end);

       }
       return res;
    }

    public static void main(String[] args) {
        String a="dvdf"
                ;
        System.out.println(lengthOfLongestSubstring(a));
    }
}
