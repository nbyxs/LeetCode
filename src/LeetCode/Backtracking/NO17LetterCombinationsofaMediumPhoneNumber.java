package LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class NO17LetterCombinationsofaMediumPhoneNumber {
    private  static List<String> res=new ArrayList<>();
   private static Map<Character,String> map=new HashMap<Character,String>(){
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
  private static int n=0;
    public static List<String> letterCombinations(String digits){
       n=digits.length();
        if(n==0)return res;

        combination(digits,0,new StringBuffer());
        return res;
    }
    /*
    combiations表示结果集
    phoneMap表示数字与字母的映射
    digits表示输入
    index表示输入的第index位
    stringbuff表示根据index生成的字符串
     */
    private static void combination(String digits, int index, StringBuffer stringBuffer) {

        if(index==n){
            res.add(new String(stringBuffer));
            return;
        }
        if(index>n)return;
        char c=digits.charAt(index);
        char[] letters=map.get(c).toCharArray();
        for(int i=0;i<letters.length;++i){
            stringBuffer.append(letters[i]);
            combination(digits,index+1,stringBuffer);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
            //不能跳过当前位置==>会将当前位置置为空
           // combination(digits,index+1,stringBuffer);
        }
    }



    public static void main(String[] args) {
        String a="23";
        //System.out.println(a);
      List<String> res=  letterCombinations(a);
        for (String  a1:res) {
            System.out.println(a1);
        }
    }
}
