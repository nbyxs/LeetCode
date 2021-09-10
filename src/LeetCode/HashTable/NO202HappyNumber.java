package LeetCode.HashTable;

import java.util.HashMap;
import java.util.Map;

/*
编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」定义为：

    对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
    然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
    如果 可以变为  1，那么这个数就是快乐数。

如果 n 是快乐数就返回 true ；不是，则返回 false 。

示例 1：

输入：19
输出：true
解释：
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

 */
public class NO202HappyNumber {
    public static boolean isHappy(int n) {

        Map<Integer,Integer> table=new HashMap<>();
        n=count(n);

        while(n!=1){
            System.out.println(n);
            if(table.containsKey(n))return false;
            table.put(n,1);
            n=count(n);
        }
        return n==1?true:false;
    }

    private static int count(int n) {
        int res=0;
        while(n!=0){
            int a=n%10;
            n/=10;
            res+=a*a;
        }
        return res;
    }

    public static void main(String[] args) {
        int n=19;
        System.out.println(isHappy(n));
    }
}
