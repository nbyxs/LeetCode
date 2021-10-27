package LeetCode.CharacterString;

public class NO14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer res=new StringBuffer();
        String s=strs[0];
        for(String s1:strs){
            if(s1.length()<s.length())s=s1;
        }
        //选择最短的字符串
        for(int i=0;i<s.length();++i){
            char a=s.charAt(i);
            for(String s1:strs){
                if(s1.charAt(i)!=a)return res.toString();

            }
            res.append(a);
        }
        return res.toString();

    }
}
