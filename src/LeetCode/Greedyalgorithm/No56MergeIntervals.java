package LeetCode.Greedyalgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
示例 1：
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2：
输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No56MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (ints, t1) -> ints[0]-t1[0]);
        List<int[]> list=new LinkedList<>();
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;++i){
            if(end<intervals[i][0]){
                list.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
            else end=Math.max(intervals[i][1],end);
        }
        list.add(new int[]{start,end});
        //System.out.println(list.toString());
        return  list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] a={{1,3},{2,5},{6,8},{8,10},{12,15}};
        System.out.println(Arrays.deepToString(merge(a)));
    }
}
