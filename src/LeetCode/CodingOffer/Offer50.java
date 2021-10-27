package LeetCode.CodingOffer;

public class Offer50 {
    public static char firstUniqChar(String s) {
        char[] list=s.toCharArray();
        char res=' ';
        int[] ch=new int[30];
        for(int i=0;i<list.length;++i){
            ch[list[i]-'a']++;

        }
        for(int i=0;i<list.length;++i){
            if(ch[list[i]-'a']==1)return list[i];
        }
return res;
    }

    public static void main(String[] args) {
        String a="loveleetcode"
                ;
        System.out.println(firstUniqChar(a));
    }
}
