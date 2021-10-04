package LeetCode.Backtracking;

import java.util.*;

public class NO51N_Queens {

    static List<List<String>> res = new ArrayList<List<String>>();
   static Set<Integer> set_x=new HashSet<>();
   static Set<Integer> set_y=new HashSet<>();
   static Set<Integer> set_z=new HashSet<>();
    static int[] queue=null;
   
    private static List<List<String>> solveNQueens(int n) {
        queue=new int[n];
        Arrays.fill(queue,-1);
        dfs(0,n);
        return res;

    }

    private static void dfs(int row,int n) {
        if(row==n){
            res.add(fill(queue,n));
            return;
        }
        for(int i=0;i<n;++i){


            int y =row-i;
            int z=i+row;
            if(set_x.contains(i)||set_y.contains(y)||set_z.contains(z))continue;
            queue[row]=i;
            set_x.add(i);
            set_y.add(y);
            set_z.add(z);
            dfs(row+1,n);
            queue[row]=-1;
            set_x.remove(i);
            set_y.remove(y);
            set_z.remove(z);

        }
    }

    public static List<String> fill(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;

    }


    public static void main(String[] args) {
        int n=4;
        List<List<String>> lists=solveNQueens(n);
        for(List<String> list:lists) System.out.println(list.toString());

    }


}
