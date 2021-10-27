package LeetCode.Array;

public class NO1013 {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum=0;
        for(int a:arr)sum+=a;
        if(sum%3!=0)return false;
        int part=sum/3;
        sum=0;
        int n=arr.length;
        int count=0;
        for(int a:arr){
            sum+=a;
            if(sum==part){
                ++count;
                sum=0;
            }
        }
return count==3;
    }
}
