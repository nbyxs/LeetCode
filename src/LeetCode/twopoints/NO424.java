package LeetCode.twopoints;

public class NO424 {
    public int characterReplacement(String s, int k) {

        int n=s.length();
        int l=0;
        int r=0;
        int[] list=new int[26];
        int count=0;
        while (r<n){
            ++list[s.charAt(r)-'A'];
            count=Math.max(count,list[s.charAt(r)-'A']);
            if(r-l+1-count>k){
                --list[s.charAt(l)-'A'];
                ++l;
            }
            ++r;
        }
        return r-l;
    }
}
