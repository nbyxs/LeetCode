package LeetCode.DP;

public class s {
    public static boolean isSubsequence(String s, String t) {

        int n=s.length();
        int m=t.length();
        if(n==0)return true;
        if(m==0)return false;
        int t1=0;
        int s1=0;
        while(s1<n&&t1<m){
//            if (t1<m&&(t.charAt(t1)!=s.charAt(s1)))++t1;
            if(t.charAt(t1)==s.charAt(s1)){
                //System.out.println(t1+" "+s1);
                ++t1;
                ++s1;
            }
            else ++t1;
        }
        System.out.println(s1+"  "+n);
        return s1==n;
    }

    public static void main(String[] args) {
        String a="axc";
        String b="abghc";
        System.out.println(isSubsequence(a,b));
    }
}
