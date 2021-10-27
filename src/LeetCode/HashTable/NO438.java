package LeetCode.HashTable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NO438 {
    public List<Integer> findAnagrams(String s, String p) {
        int n=s.length();
        int m=p.length();
        List<Integer> list=new ArrayList<>();
        if(n<m)return list;
        int[] s_list=new int[26];
        int[] p_list=new int[26];
        for(int i=0;i<m;++i){
            ++s_list[s.charAt(i)-'a'];
            ++p_list[p.charAt(i)-'a'];
        }
        if(Arrays.equals(s_list,p_list))list.add(0);

        for(int i=m;i<n;++i){
            ++s_list[s.charAt(i)-'a'];
            --s_list[s.charAt(i-m)-'a'];
            if(Arrays.equals(s_list,p_list))list.add(i-m+1);
        }return list;
    }
}
