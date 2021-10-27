package LeetCode.HashTable;

import java.util.Arrays;

public class NO1539 {
    public static int findKthPositive(int[] arr, int k) {
        for(int a:arr)if(a<=k)++k;
        return k;

    }

    public static void main(String[] args) {
        int[] a={2,3,4,7,11};
        System.out.println(findKthPositive(a,5));
    }
}
