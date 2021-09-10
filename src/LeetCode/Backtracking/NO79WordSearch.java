package LeetCode.Backtracking;
/*
给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */

public class NO79WordSearch {

    public static boolean exist(char[][] board, String word) {

        int n=board.length;
        int m=board[0].length;
        boolean[][] str=new boolean[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(check(board,str,i,j,word,0))return true;
            }
        }
return  false;
    }

    private static boolean check(char[][] board, boolean[][]str,int length, int width, String word, int index) {
        if(index>=word.length()-1)return true;
        else if(board[length][width]!=word.charAt(index))return false;
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        boolean res=false;
        str[length][width]=true;
        for(int i=0;i<4;++i){
            int x=length+dir[i][0];
            int y=width+dir[i][1];
            if(x>=0&&x<board.length&&y>=0&&y<board[0].length){
                if(!str[x][y]){//一个分支成功无需判断另一分支
                    boolean flag=check(board,str,x,y,word,index+1);
                    if(flag){
                        res=true;
                        break;
                    }
                }
            }

        }
        str[length][width]=false;
        return res;

    }


    public static void main(String[] args) {

        char[][] board ={{'a'}};

        String word = "a";
        System.out.println(exist(board,word));
        String s = "祝你考出好成绩！";
        System.out.println(s.length());
    }

}
