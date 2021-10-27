package LeetCode.HashTable;

import javax.print.DocFlavor;
import java.util.HashMap;

public class NO205 {
    public  static  boolean isIsomorphic(String s, String t) {

        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int[] preIndexOfs = new int[256];
        int[] preIndexOft = new int[256];
        for (int i = 0; i < chars.length; i++) {
            if (preIndexOfs[chars[i]] != preIndexOft[chart[i]]) {
                return false;
            }
            preIndexOfs[chars[i]] = i + 1;
            preIndexOft[chart[i]] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        String s="badc";
        String t="baba";
        System.out.println(isIsomorphic(s,t));
    }
}
