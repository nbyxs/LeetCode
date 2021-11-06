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
    public  static int lengthOfLongestSubstring_review(String s){
        int n=s.length();
        if(n<=1)return n;
        HashMap<Character,Integer> map=new HashMap<>();
        int start=0;
        int res=0;
        for(int end=0;end<n;++end){
            char c=s.charAt(end);
            if(map.containsKey(c)){
                start=Math.max(start,map.get(c)+1);
            }
            res=Math.max(end-start+1,res);
            map.put(c,end);
        }
        return res;
    }
    public static void main(String[] args) {
        String a="1234"
                ;
        System.out.println(lengthOfLongestSubstring(a));
        System.out.println(lengthOfLongestSubstring_review(a));
    }
}
