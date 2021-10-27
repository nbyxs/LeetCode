package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class NO167 {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;++i){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
            //防止数组中重复元素更新索引，所以需要在判断完之后更新
            //例 {0,0,1,2} 0
        }
        return nums;
    }
}
