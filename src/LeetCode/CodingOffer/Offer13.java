package LeetCode.CodingOffer;

import java.util.LinkedList;
import java.util.Queue;

/*
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
一个机器人从坐标 [0, 0] 的格子开始移动，
它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
请问该机器人能够到达多少个格子？
示例 1：
输入：m = 2, n = 3, k = 1
输出：3
 */
public class Offer13 {
    public static int movingCount(int m, int n, int k) {
        if(k==0)return 1;
        Queue<int[]> queue=new LinkedList<>();
        int ans=1;
        int[] x={0,1};
        int[] y={1,0};
        queue.offer(new int[]{0,0});
        boolean[][] str=new boolean[m][n];
        str[0][0]=true;
        while(!queue.isEmpty()){
            int[] t=queue.poll();
            for(int i=0;i<2;++i){
                int x1=t[0]+x[i];
                int y1=t[1]+y[i];
                if(x1<0||x1>=m||y1<0||y1>=n||get(x1)+get(y1)>k)continue;
                str[x1][y1]=true;
                queue.offer(new int[]{x1,y1});
                ans++;
            }
        }
        return ans;

    }

    private static int get(int x) {
        int res=0;
        while(x!=0){
            res+=x%10;
            x/=10;
        }
        return res;
    }

    public static void main(String[] args) {
       // System.out.println(get(10));
        System.out.println(movingCount(2,3,1));
    }
}
