package LeetCode.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NO49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            int[] list=new int[26];
            for(int i=0;i<s.length();++i)++list[s.charAt(i)-'a'];
            StringBuffer key=new StringBuffer();
            for(int i=0;i<26;++i){
                if(list[i]>0){
                    key.append(i+'a').append(list[i]);
                }
            }
            String key_s=key.toString();
            List<String> l=new ArrayList<>();

            if(map.containsKey(key_s)){
               l=map.getOrDefault(key_s,new ArrayList<>());

            }
            l.add(s);
             map.put(key_s,l);
        }

       return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] a={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(a).toString());
    }
}
