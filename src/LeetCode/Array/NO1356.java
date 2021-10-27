package LeetCode.Array;

import java.util.Arrays;
import java.util.Comparator;

public class NO1356 {
    public static int[] sortByBits(int[] arr) {
        int n=arr.length;
        Integer[] a=new Integer[n];
        for(int i=0;i<n;++i)a[i]=arr[i];
        Arrays.sort(a, (t1, t2) -> {
            int t1_number=lowBit(t1);
            int t2_number=lowBit(t2);
      //     int t= Integer.bitCount(t1);

            if(t1_number!=t2_number)return t1_number-t2_number;
            return t1-t2;
        });
        for(int i=0;i<n;++i)arr[i]=a[i];

        for(int a1:arr) System.out.print(a1+" ");
        return arr;
    }

    private static int lowBit(Integer t) {
        int n=t;
        int count=0;
        while (n>0){
            n-=(n&(-n));
            ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a={0,1,2,3,4,5,6,7,8};
        sortByBits(a);
    }
}
