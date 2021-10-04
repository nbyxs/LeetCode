package LeetCode.Greedyalgorithm;

import java.util.Arrays;

/*
给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
以这种方式修改数组后，返回数组可能的最大和。
示例 1：
输入：A = [4,2,3], K = 1
输出：5
解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
示例 2：
输入：A = [3,-1,0,2], K = 3
输出：6
解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
示例 3：
输入：A = [2,-3,-1,5,-4], K = 2
输出：13
解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO1005MaximizeSumOfArrayAfterKNegations {
    public static int largestSumAfterKNegations(int[] nums, int k) {

        Arrays.sort(nums);
        int n_number=0;
        //找到第一个非负数
        while(nums[n_number]<0)++n_number;
        if(n_number==0)return count(nums,k,n_number);

        if(k<n_number){
            for(int i=0;i<k;++i)nums[i]=-nums[i];
            return count(nums,0,k);
        }
        int m=k/n_number;
        if((m&1)==1){
            k-=m*n_number;
        }
        else  k-=(m-1)*n_number;

        for(int i=0;i<n_number;++i)nums[i]=-nums[i];
        return count(nums,k,n_number);


    }
public  static int count(int[] nums,int k,int index){
    int sum=0;
    for (int i=0;i<nums.length;++i)sum+=nums[i];
    if((k&1)==1&&index>0)sum-=2*Math.min(nums[index],nums[index-1]);
    return sum;
}
//只对最小值进行翻转
    public int largestSumAfterKNegations_plus(int[] nums, int k) {
        //首先进行排序（可能有负数也可能没有负数）
        Arrays.sort(nums);
        int minIndex = 0;
        int sum = 0;
        while(k > 0){
            nums[minIndex] = -nums[minIndex];
            k--;
            //只有后面元素存在且小于当前元素时，更新最小元素的索引
            //对于有负数的情况会先把负数求反，对于正数的话，始终对最小的改变
            if(minIndex + 1 < nums.length && nums[minIndex + 1] < nums[minIndex]){
                minIndex++;
            }
        }
        for(int x : nums){
            sum += x;
        }
        return sum;
    }


    public static void main(String[] args) {
       int[] A = {4,2,3};int K = 1;


        System.out.println(largestSumAfterKNegations(A,K));
    }
}
