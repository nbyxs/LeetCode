package LeetCode.TwoPoints;

public class NO845 {
    public static int longestMountain(int[] arr) {
        int left=0;
        int right=0;
        int n=arr.length;
        int count=0;
        if(n<=2)return 0;
        while (right<n-1){
            //找上升
            while (right<n-1&&arr[right]<arr[right+1])++right;
            //没找到就一起往后挪，避免没有山峰的数组的死循环
            if(left==right){
                ++left;
                ++right;
                continue;
            }
            //找到上升找下降
            int mid=right;
            while (right<n-1&&arr[right]>arr[right+1])++right;
            //找到了就修改
          if(right > mid){
              count=Math.max(right-left+1,count);
          }
          //没找到就挪
          left=right;

        }

        return count;
    }

    public static void main(String[] args) {
        int[] a={2,2,2};
        System.out.println(longestMountain(a));
    }
}
