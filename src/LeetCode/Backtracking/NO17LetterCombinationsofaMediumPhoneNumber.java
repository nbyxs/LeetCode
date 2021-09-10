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
    public static List<String> letterCombinations(String digits){
        List<String> res=new ArrayList<>();
        if(digits.length()==0)return  res;
        Map<Character,String> map=new HashMap<Character,String>(){
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
        backtrack(res,map,digits,0,new StringBuffer());
        return  res;
    }
/*
combiations表示结果集
phoneMap表示数字与字母的映射
digits表示输入
index表示输入的第index位
stringbuff表示根据index生成的字符串
 */
    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination){
        if(index==digits.length()){
            combinations.add(combination.toString());
            return;
        }
        else {
            char c=digits.charAt(index);
            String letter=phoneMap.get(c);
            for(int i=0;i<letter.length();++i){
                combination.append(letter.charAt(i));
                backtrack(combinations,phoneMap,digits,index+1,combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static List<String> letterCombinations1(String digits){
        List<String> res=new ArrayList<>();
        if(digits.length()==0)return  res;
        Map<Character,String> map=new HashMap<Character,String>(){
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
        backtrack1(res,map,digits,0,new StringBuffer());
        return  res;


    }
    public static void backtrack1(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination){

        if(index==digits.length()){
            combinations.add(combination.toString());
            return;
        }
        char c=digits.charAt(index);
        String s=phoneMap.get(c);
        for(int i=0;i<s.length();++i){
            combination.append(s.charAt(i));
            backtrack1(combinations,phoneMap,digits,index+1,combination);
            combination.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        String a="23";
        //System.out.println(a);
      List<String> res=  letterCombinations1(a);
        for (String  a1:res) {
            System.out.println(a1);
        }
    }
}
