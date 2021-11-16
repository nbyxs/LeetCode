package LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
示例 1：
输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
示例 2：
输入：s = "0000"
输出：["0.0.0.0"]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/restore-ip-addresses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO93RestoreIPAddresses {
    static List<String> list=new ArrayList<>();
    static  int length=0;
    static List<String> list_ip=new ArrayList<>();
    public static List<String> restoreIpAddresses(String ip) {
        length=ip.length();
        if(length>12)return list;
        dfs(ip,0);
        return list;
    }

    private static void dfs(String ip, int index) {
        if((list_ip.size())+(length-index+1)<=4)return;
        if(list_ip.size()==4&&index>=length){
            StringBuffer res=new StringBuffer();
            for(String p:list_ip){
                res.append(p).append('.');
            }
            res.deleteCharAt(res.length()-1);
            list.add(res.toString());
        }
        if(index>=length)return;
        for(int i=index+1;i<=length;++i){
            String ipCheck=ip.substring(index,i);
            if(check(ipCheck)){
                list_ip.add(ipCheck);
            }
            else  continue;
            dfs(ip,i);
            list_ip.remove(list_ip.size()-1);
        }
    }

    private static boolean check(String ipCheck) {
        if(ipCheck.length()>3)return false;
        if(ipCheck.charAt(0)=='0'&&ipCheck.length()>1)return false;
        int number=Integer.parseInt(ipCheck);
        return number<=255&&number>=0;
    }

    public static void main(String[] args) {
        String IP="010010";
        restoreIpAddresses(IP);
        System.out.println("_____________");
        for(String s:list) System.out.println(s);
    }




}



