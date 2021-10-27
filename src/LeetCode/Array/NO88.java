package LeetCode.Array;
//所有玩家都全力向前冲刺, 却不知道向后才是胜利之门。-《头号玩家》
public class NO88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index=m+n-1;
        int index_1=m-1;
        int index_2=n-1;
        while (index_1>=0&&index_2>=0){
            if(nums1[index_1]>=nums2[index_2]){
                nums1[index--]=nums1[index_1--];
            }
            else nums1[index--]=nums2[index_2--];
        }
        //由于是对num1进行修改且num1是升序的，所以无需调整
        while (index_2>=0)nums1[index--]=nums2[index_2--];
    }
}
