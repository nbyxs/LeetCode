package NOWCODER;

import java.util.*;


public class NC111Solution {
    /*
     * 最大数
     * @param nums int整型一维数组
     * @return string字符串
     */
    public String solve (int[] nums) {
        // write code here
        ArrayList<String> list =new ArrayList<>();
        for(int i=0;i< nums.length;i++){
            list.add(String.valueOf(nums[i]));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return  (o1+o2).compareTo(o1+o2);
            }
        });
        if(list.get(0).equals("0"))return  "0";
        StringBuffer res=new StringBuffer();
        for(int i=0;i<list.size();i++){
            res.append(list.get(i));
        }
        return  res.toString();
    }
}
