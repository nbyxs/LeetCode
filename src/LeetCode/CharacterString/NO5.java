package LeetCode.CharacterString;

public class NO5 {
    public static String longestPalindrome(String s) {

        int n=s.length();
        if(n<=1)return s;
        int start=0;
        int end=0;
        int len=1;
        for(int i=0;i<n;++i){
            int len1=MaxPalindrome(s,i,i);
            int len2=MaxPalindrome(s,i,i+1);
            len=Math.max(len1,len2);
            if(len>(end-start)){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        System.out.println(len);
        return s.substring(start,end+1);
    }

    private static int MaxPalindrome(String s, int left, int right) {
        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            --left;
            ++right;
        }
        return right-left-1;
    }

    public static void main(String[] args) {
        String s="babad";
        System.out.println(longestPalindrome(s));
    }
}
