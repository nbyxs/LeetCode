package LeetCode.Backtracking;

import java.util.*;

public class NO51N_Queens {
   public static List<List<String>> solveNQueens(int n){
       List<List<String>> res=new ArrayList<>();
       int[] queue=new int[n];
       Arrays.fill(queue,-1);
       Set<Integer> x=new HashSet<>();
       Set<Integer> y=new HashSet<>();
       Set<Integer> z=new HashSet<>();
       search(res,n,0,queue,x,y,z);
       return res;
   }

    private static void search(List<List<String>> res, int n, int row, int[] queue,Set<Integer> x, Set<Integer> y, Set<Integer> z) {
        if (n == row) {
            List<String> list=make(queue,n);
            res.add(list);
        }
        for(int i=0;i<n;++i){
            int a=row-i,b=row+i;
            if(x.contains(i))continue;
            if(y.contains(a))continue;
            if(z.contains(b))continue;
            x.add(i);
            y.add(a);
            z.add(b);
            queue[row]=i;
            search(res,n,row+1,queue,x,y,z);
            x.remove(i);
            y.remove(a);
            z.remove(b);
            queue[row]=-1;
        }
    }

    private static List<String> make(int[] queue, int n) {
       List<String> stringList=new ArrayList<>();
       for(int i=0;i<n;++i){
           char[] chars=new char[n];
           Arrays.fill(chars,'.');
           chars[queue[i]]='Q';
           stringList.add(new String(chars));
       }
       return stringList;
    }

    public static void main(String[] args) {
        int n=4;
        List<List<String>> lists=solveNQueens(n);
        for(List<String> list:lists) System.out.println(list.toString());

    }
}
