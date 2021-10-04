package LeetCode.Backtracking;

import java.util.*;

/*
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
回文串 是正着读和反着读都一样的字符串。
示例 1：
输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
示例 2：
输入：s = "a"
输出：[["a"]]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-partitioning
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO131PalindromePartitioning {
    private static List<List<String>> res=new ArrayList<List<String>>();
    private static List<String> list=new ArrayList<>();
    private  static  int n=0;
    public static List<List<String>> partition(String s) {

        n=s.length();
           for(int i=1;i<=n;++i){
               dfs(s,0,i);
           }
        return res;
    }
//s, index当前未切割的第一个字母，number要求切割的段数
    private static void dfs(String s,int index, int number) {
        if(list.size()+(n-index+1)<number)return;
        if(list.size()==number&&index>=n){
            //System.out.println(list.toString());
          if(check(list))  res.add(new ArrayList<>(list));
            return;
        }
        if(index>=n)return;
        for(int i=index+1;i<=n;++i){
            list.add(s.substring(index,i));//substring 左闭右开，所以下一个切割的元素位置是 i
           // System.out.println(list.toString()+" **");
            dfs(s,i,number);
            list.remove(list.size()-1);

        }
    }

    private static boolean check(List<String> list) {
        for(String s:list){
            if(!check_palindrome(s))return false;
        }
        return true;
    }

    private static boolean check_palindrome(String s) {
        char[] chars=s.toCharArray();
        int length=chars.length;
        if(length==1)return true;
        for(int i=0,j=length-1;i<=j;++i,--j){
            if(chars[i]!=chars[j])return false;
        }
        return true;
    }

    Deque<String> deque = new LinkedList<>();

    public List<List<String>> partition1(String s) {
        backTracking(s, 0);
        return res;
    }

    private void backTracking(String s, int startIndex) {
        //如果起始位置大于s的大小，说明找到了一组分割方案
        if (startIndex >= s.length()) {
            res.add(new ArrayList(deque));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            //如果是回文子串，则记录
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                deque.addLast(str);
            } else {
                continue;
            }
            //起始位置后移，保证不重复
            backTracking(s, i + 1);
            deque.removeLast();
        }
    }
    //判断是否是回文串
    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String a="a";

        partition(a);
        System.out.println("+++++++++++++++++++++");
        for(List<String> list:res) System.out.println(list.toString());
    }
}
