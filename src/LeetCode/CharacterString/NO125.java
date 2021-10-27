package LeetCode.CharacterString;

public class NO125 {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        StringBuffer res=new StringBuffer();
        for(int i=0;i<s.length();++i){
           char c=s.charAt(i);
           if((c>='a'&&c<='z')||(c>='0'&&c<='9'))res.append(c);
        }
        for(int i=0,j=res.length()-1;i<=j;++i,--j){
            if(res.charAt(i)!=res.charAt(j))return false;
        }
return true;

    }
}
