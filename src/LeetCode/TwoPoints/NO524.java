package LeetCode.TwoPoints;

import java.util.Arrays;
import java.util.List;

public class NO524 {
    public  static String findLongestWord(String s, List<String> dictionary) {
        int n=s.length();
        String res="";
        for(String d:dictionary){
            int m=d.length();
            if(m>n||m<res.length())continue;
            int left_d=0;
            int left_s=0;
            while (left_d<m&&left_s<n){
                if(d.charAt(left_d)==s.charAt(left_s)){
                    ++left_d;
                  ++left_s;
                }
                else ++left_s;
            }
            if(left_d==m){
                if(res.length()<m)res=d;

              else if(d.compareTo(res) < 0) res=d;//多种情况按字典序
            }
        }return  res;

    }

    public static void main(String[] args) {
        String s= "abce";
        List<String> list= Arrays.asList("abe","abc","monkey","plea");
        System.out.println(findLongestWord(s,list));
    }
}
