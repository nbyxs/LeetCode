package LeetCode.CodingOffer;

import java.util.HashMap;
import java.util.Map;

public class Offer48 {
    public static int lengthOfLongestSubstring(String s) {
        int start=0;
        Map<Character,Integer> map=new HashMap<>();
        char[] list=s.toCharArray();
        int ans=1;
        for(int end=0;end<list.length;++end){
            if(map.containsKey(list[end])){
                start=Math.max(start,map.get(list[end])+1);
            }
            ans=Math.max(ans,end-start+1);
            map.put(list[end],end);
        }
return ans;
    }

    public static void main(String[] args) {
        String a="pwwkew";
        System.out.println(lengthOfLongestSubstring(a));
    }
}
