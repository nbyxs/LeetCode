package LeetCode.DP.Completelybackpack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
说明：
    拆分时可以重复使用字典中的单词。
    你可以假设字典中没有重复的单词。
示例 1：
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：
输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-break
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NO139WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordDictSet = new HashSet(wordDict);
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=0;i<=n;++i)
            for(int j=0;j<i;++j){
                if(dp[j] && wordDictSet.contains(s.substring(j, i))){
                    dp[i]=true;
                    break;
                }
            }
        return dp[n];
    }

    private static boolean check(String substring, List<String> wordDict) {
        for(String s:wordDict)if(s.equals(substring))return true;
        return false;
    }

    public static void main(String[] args) {

        String s="catandog";
        List<String> list= Arrays.asList("cat", "and","dog");
        System.out.println(wordBreak(s,list));
    }
}
