package LeetCode.CharacterString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NO415 {
    public static String addStrings(String num1, String num2) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        int n=num1.length();
        int m=num2.length();
        int count=0;
        for(int i=n-1;i>=0;--i){
            list1.add(num1.charAt(i)-'0');
        }
        for(int i=m-1;i>=0;--i){
            list2.add(num2.charAt(i)-'0');
        }
        for(int i=0;i<Math.min(n,m);++i){
            int number=list1.get(i)+list2.get(i)+count;
            list1.set(i,number%10);
            count=number/10;
        }

        if(m>n){
            for(int i=n;i<m;++i){
                int number=list2.get(i)+count;
                list1.add(number%10);
                count=number/10;
            }

        }
        else  {
            for(int i=m;i<n;++i){
                int number=list1.get(i)+count;
                list1.set(i,number%10);
                count=number/10;
            }
        }
        if(count==1)list1.add(count);
        Collections.reverse(list1);
        StringBuffer s=new StringBuffer();
        for(int a:list1)s.append(a);
        return s.toString();


    }

    public static void main(String[] args) {
        String a="99";
        String b="99";
        System.out.println(addStrings(a,b));
    }
}
