package LeetCode.HashTable;

import java.util.HashMap;
import java.util.Map;

/*
给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
如果可以构成，返回 true ；否则返回 false。
(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，
组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次.)
示例 1：
输入：ransomNote = "a", magazine = "b"
输出：false
示例 3：
输入：ransomNote = "aa", magazine = "aab"
输出：true
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ransom-note
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO383 {
    public static boolean canConstruct(String ransomNote, String magazine) {

        if(ransomNote.length()>magazine.length())return false;
        Map<Character,Integer> list=new HashMap<>();
        for(int i=0;i<magazine.length();++i){
            char ch=magazine.charAt(i);
            list.put(ch,list.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<ransomNote.length();++i){
            char ch=ransomNote.charAt(i);

            list.put(ch,list.getOrDefault(ch,0)-1);
            if(list.get(ch)==null||list.get(ch)<0)return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String a="aac";
        String b="aab";
        System.out.println(canConstruct(a,b));
    }
}
