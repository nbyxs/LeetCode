package LeetCode.HashTable;

import java.util.*;

public class NO629 {
    public  static List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        List<String> list=new ArrayList<>();
        for(String w:words)map.put(w,map.getOrDefault(w,0)+1);
        PriorityQueue<Map.Entry<String,Integer>> queue=new PriorityQueue<>((t1, t2) -> {
            if(t1.getValue()-t2.getValue()!=0)return t2.getValue()-t1.getValue();
            else return t1.getKey().compareTo(t2.getKey());
        });
        queue.addAll(map.entrySet());
        for(Map.Entry<String,Integer> m:queue) System.out.println(m.getKey()+" "+m.getValue());
        for(int i=0;i<k;++i){

            list.add(Objects.requireNonNull(queue.poll()).getKey());
        }
        return list;

    }

    public static void main(String[] args) {
        String[] a={"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(a,2).toString());

    }
}
