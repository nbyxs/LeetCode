package LeetCode.Sort;

import java.util.Arrays;
import java.util.Comparator;

public class NO179 {
    public  static String largestNumber(int[] nums) {
        Integer[] a=new Integer[nums.length];
        for(int i=0;i<nums.length;++i)a[i]=nums[i];
        Arrays.sort(a, (t1, t2) -> {
            StringBuffer t_1=new StringBuffer();
            t_1.append(t1).append(t2);
            StringBuffer t_2=new StringBuffer();
            t_2.append(t2).append(t1);
            return  t_2.compareTo(t_1);

        });
        //如果开头为0，直接返回
        if(a[0]==0)return "0";
        StringBuffer s=new StringBuffer();

        for(int x:a){
           // System.out.print(x+" ");
            s.append(x);
        }

        return s.toString();
    }

    public static void main(String[] args) {
        int[] nums={10,0};
        System.out.println(largestNumber(nums));
    }
}
