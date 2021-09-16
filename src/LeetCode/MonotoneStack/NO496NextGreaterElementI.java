package LeetCode.MonotoneStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值
nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出 -1 。
示例 1:
输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
输出: [-1,3,-1]
解释:
    对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
    对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
    对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
示例 2:
输入: nums1 = [2,4], nums2 = [1,2,3,4].
输出: [3,-1]
解释:
    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-greater-element-i
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO496NextGreaterElementI {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] res=new  int[n];
        //for(int i=0;i<n;++i)res[i]=-1;
        Stack<Integer> stack=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();
        stack.push(nums2[0]);
        for(int i=0;i<m;++i){
            while (!stack.isEmpty()&&nums2[i]>stack.peek()){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for(int i=0;i<n;++i)res[i]=map.getOrDefault(nums1[i],-1);
        return  res;
    }

    public static void main(String[] args) {
        int[] a={1,3,5,2,4};
        int[] b={6,5,4,3,2,1,7};
        int[] res=nextGreaterElement(a,b);
        for(int i=0;i<res.length;++i) System.out.print(res[i]+" ");
    }
}
