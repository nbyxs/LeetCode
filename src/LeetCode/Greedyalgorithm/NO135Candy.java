package LeetCode.Greedyalgorithm;

import java.util.Arrays;

/*
老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
你需要按照以下要求，帮助老师给这些孩子分发糖果：
    每个孩子至少分配到 1 个糖果。
    评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
那么这样下来，老师至少需要准备多少颗糖果呢？
示例 1：
输入：[1,0,2]
输出：5
解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。

示例 2：

输入：[1,2,2]
输出：4
解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/candy
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO135Candy {
    public static int candy(int[] ratings) {

        int n=ratings.length;
        if(n<=1)return n;
        if(n==2)return ratings[0]-ratings[1]==0?2:3;

        int[] candy=new int[n];
        int sum=0;
        Arrays.fill(candy,1);
        //右比左大
        for(int i=1;i<n;++i){
          if(ratings[i]>ratings[i-1])candy[i]=candy[i-1]+1;
        }
        //左比右大

        for(int i=n-2;i>=0;--i){
            if(ratings[i]>ratings[i+1]) candy[i]=Math.max(candy[i],candy[i + 1] + 1);
        }
        for(int i=0;i<n;++i)sum+=candy[i];
        return sum;
    }

    public static void main(String[] args) {
        int[] a={1,3,4,5,2}        ;
        System.out.println(candy(a));
    }
}
