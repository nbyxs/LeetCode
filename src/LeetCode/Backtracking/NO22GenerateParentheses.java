package LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NO22GenerateParentheses {
    public  static  List<String> generateParenthesis(int n) {

        List<String> res=new ArrayList<>();
        if(n==0)return  res;
        search(res,new StringBuffer(),0,0,n);
        return  res;
    }

    private static void search(List<String> res, StringBuffer stringBuffer, int left, int right, int n) {
        if(stringBuffer.length()==n*2){
            res.add(stringBuffer.toString());
            return;
        }
        if(left<n){
            stringBuffer.append('(');
            search(res,stringBuffer,left+1,right,n);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
        if(right<left){
            stringBuffer.append(')');
            search(res,stringBuffer,left,right+1,n);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
    }
    public  static  List<String> generateParenthesis1(int n){
        List<String> res=new ArrayList<>();
        search1(res,new StringBuffer(),0,0,n);
        return res;
    }
    private static void search1(List<String> res, StringBuffer stringBuffer, int left, int right, int n){
        if(left==n&&right==n){
            res.add(stringBuffer.toString());
            return;
        }
        if(left<n){
            stringBuffer.append("(");
            search1(res,stringBuffer,left+1,right,n);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
        if(right<left){
            stringBuffer.append(")");
            search1(res,stringBuffer,left,right+1,n);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);

        }

    }
    public static void main(String[] args) {

        int n=1;
        List<String> list=generateParenthesis1(n);
        for(String l:list) System.out.println(l);

    }
}
