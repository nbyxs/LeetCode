package LeetCode.CharacterString;

import java.util.Arrays;

/*
给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
    如果剩余字符少于 k 个，则将剩余字符全部反转。
    如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
示例 1：
输入：s = "abcdefg", k = 2
输出："bacdfeg"
示例 2：
输入：s = "abcd", k = 2
输出："bacd"
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-string-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO541ReverseStringII {
    public static String reverseStr(String s, int k) {

        char[] c=s.toCharArray();
        int n=c.length;
        for(int i=0;i<n;i+=2*k){
            if(n-i<k)reverseChar(i,n-1,c);
            else reverseChar(i,i+k-1,c);
        }

        return  new String(c);
    }
    private static void reverseChar(int begin,int end,char[] s){
        for (int left = begin, right = end; left <= right; ++left, --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }

    public static void main(String[] args) {
        String s = "abcd";int k = 2;
        System.out.println(reverseStr(s,k));
    }
}
