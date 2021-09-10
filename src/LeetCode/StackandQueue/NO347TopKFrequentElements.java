package LeetCode.StackandQueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
示例 1:
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/top-k-frequent-elements
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO347TopKFrequentElements {
    public  static int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> list=new HashMap<>();
        for(int num:nums){
            list.put(num,list.getOrDefault(num,0)+1);
        }
        return  select(list,k);
    }

    private static int[] select(Map<Integer, Integer> list, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });

        for(Map.Entry<Integer, Integer> l:list.entrySet()){

            int key=l.getKey();int value=l.getValue();
           if(queue.size()==k){
               int value1=queue.peek()[1];
               if(value1<value){
                   queue.poll();
                   queue.offer(new int[]{key,value});
               }
           }
           else queue.offer(new int[]{key,value});
        }

        int index=0;
        int[] res=new int[k];
        while (!queue.isEmpty()){
            res[index++]=queue.poll()[0];
        }
        return res;
    }
}
