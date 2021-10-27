package LeetCode.HashTable;

public class NO525 {
    public int findMaxLength(int[] nums) {

        int zeroNum=0;
        int oneNum=0;
        int l=0;
        int res=0;
        for(int i=0;i<nums.length;++i){
            if (nums[i] == 0) {
                zeroNum++;
            } else {
                oneNum++;
            }
            if(zeroNum==oneNum){
                res=Math.max(res,i-l+1);
            }

        }
        return res;
    }
}
