package LeetCode.Array;

public class NO922 {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if ((nums[i] &1) == 1) {
                while ((nums[j] & 1) == 1) {
                    j += 2;
                }
                swap(nums, i, j);
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    public void main(String[] args) {
        int[] a={2,3,1,1,4,0,0,4,3,3};
        sortArrayByParityII(a);
    }
}
