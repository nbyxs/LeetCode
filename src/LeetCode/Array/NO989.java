package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NO989 {
    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list=new ArrayList<>();
        while (k>0){
            list.add(k%10);
            k/=10;
        }
        for(int i=0,j=num.length-1;i<j;++i,--j){
            int t=num[i];
            num[i]=num[j];
            num[j]=t;
        }
        int count=0;
        int index;
       for(index=0;index<num.length&&index<list.size();++index){
           int a=list.get(index);
           int number=a+num[index]+count;
           list.set(index,number%10);
           count=number/10;
        }

      if(num.length>list.size()){
          for(;index<num.length;++index){
              int number=num[index]+count;
              list.add(number%10);
              count=number/10;
          }
          //数组 【9,9,9,9】 k=1；
          if(count>0)list.add(count);
      }
     else {
         for(;index<list.size();++index){
              int number=list.get(index)+count;
              list.set(index,number%10);
              count=number/10;
          }
         if(count>0)list.add(count);
      }
     Collections.reverse(list);
     return list;
    }
    public List<Integer> addToArrayForm_1(int[] num, int k) {
        List<Integer> res = new ArrayList<Integer>();
        int n = num.length;
        for (int i = n - 1; i >= 0 || k > 0; --i, k /= 10) {
            if (i >= 0) {
                k += num[i];
            }
            res.add(k % 10);
        }
        Collections.reverse(res);
        return res;
    }


    public static void main(String[] args) {
        int[] a={8,9,9,9};
        int k=111;
        System.out.println(addToArrayForm(a,k).toString());
    }
}
