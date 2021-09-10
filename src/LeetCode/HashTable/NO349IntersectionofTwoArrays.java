package LeetCode.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
给定两个数组，编写一个函数来计算它们的交集。
示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]

 */
public class NO349IntersectionofTwoArrays {
    public  static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> n1=new HashSet<>();
        Set<Integer> n2=new HashSet<>();
        for(int  n:nums1)n1.add(n);
        for(int n:nums2)n2.add(n);
        return getintsetction(n1,n2);
    }

    private static int[] getintsetction(Set<Integer> n1, Set<Integer> n2) {
        if(n1.size()>n2.size())return getintsetction(n2,n1);
        Set<Integer> res=new HashSet<>();
        for(int num:n1){
            if(n2.contains(num))res.add(num);
        }
        int[] array=new int[res.size()];
        int index=0;
        for(int num:res)array[index++]=num;
        return array;
    }

    public static void main(String[] args) {
        int[] nums1={1,1};
        int[] nums2={2,2};
        int[] res=intersection(nums1,nums2);
        for(int i=0;i<res.length;++i ) System.out.print(res[i]);
}
}
