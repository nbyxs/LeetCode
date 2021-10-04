package LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;
/*
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
说明：
    所有数字都是正整数。
    解集不能包含重复的组合。
示例 1:
输入: k = 3, n = 7
输出: [[1,2,4]]
示例 2:
输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO216CombinationSumIII {
    //力扣提交要将去除static修饰符
    private static List<List<Integer>> res=new ArrayList<>();
    private static List<Integer> list=new ArrayList<>();
    public static List<List<Integer>> combinationSum3(int k, int n) {

        combination(n,1,k);
        return res;
    }

    private static void combination(int n, int index, int k) {
        if(list.size()+(9-index)+1<k)return;

        if(n<0)return;
        if(k==list.size()&&n==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(index>9)return;
        list.add(index);
        combination(n-index,index+1,k);
        list.remove(list.size()-1);
        combination(n,index+1,k);
    }

    public static void main(String[] args) {
        int k = 3, n = 9;
        combinationSum3(k,n);
        for(List<Integer> res:res) System.out.println(res.toString());
    }
}
