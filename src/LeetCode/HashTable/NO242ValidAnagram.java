package LeetCode.HashTable;

import java.util.HashMap;
import java.util.Map;

/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true

 */
public class NO242ValidAnagram {
    public static boolean isAnagram(String s, String t) {

        if(s.length()!=t.length())return false;
        Map<Character,Integer> res=new HashMap<>();

        for(int i=0;i<s.length();++i){
            char a=s.charAt(i);
            res.put(a,res.getOrDefault(a,0)+1);
        }
        for(int i=0;i<t.length();++i){
            char a=t.charAt(i);
            res.put(a,res.getOrDefault(a,0)-1);
            if(res.get(a)<0)return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String a="anagram";
        String t= "nagaram";
        System.out.println(isAnagram(a,t));


    }
}
