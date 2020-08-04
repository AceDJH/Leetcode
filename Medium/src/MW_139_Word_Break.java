import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author AceDJH
 * @Date 2020/3/18 21:29
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class MW_139_Word_Break {
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println(wordDict);
        System.out.println(new Solution139().wordBreak(s, wordDict));
    }
}

/*这种写法有一个错误，无法考虑其他种组合
eg：输入:
"cars"
["car","ca","rs"]
输出
false
预期结果
true
无法通过这个测试用例，且未想到该如何解决
class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int i = 0;
        boolean isFind = false;
        int wordLength = 0;
        while (i < s.length()){
            for (String s1 : wordDict) {
                for (int i1 = 0; i1 < s1.length(); i1++) {
                    if (s.charAt(i + i1) == s1.charAt(i1)){
                        if (i1 == s1.length() - 1){
                            isFind = true;
                            wordLength = s1.length();
                            break;
                        }
                    }else {
                        break;
                    }
                }
                if (isFind)
                    break;
            }
            if (isFind){
                i += wordLength;
                isFind = false;
            }else {
                return false;
            }
        }
        return i == s.length();
    }
}*/

/*使用暴力法,利用递归和回溯,但是时间复杂度过高,以下这种例子,会超出时间限制
"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return word_break(s, new HashSet<>(wordDict), 0);
    }
    // 使用Set去重复，加快搜索速度
    public boolean word_break(String s, Set<String> wordDict, int start){
        if (start == s.length())
            return true;
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_break(s, wordDict, end))
                return true;
        }
        return false;
    }
}*/

// 记忆化回溯,通过记录结果,剪枝
/*class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return word_break(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }
    // 由于boolean默认值为false,无法判断有无计算过,因此使用Boolean,未使用过则为null
    public boolean word_break(String s, Set<String> wordDict, int start, Boolean[] memo){
        if (start == s.length())
            return true;
        if (memo[start] != null)
            return memo[start];
        // 使用了递归,脑海中就应该出现弹栈出栈的过程,因此相当于是走到底后再往回走,因此应是memo[start]
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_break(s, wordDict, end, memo))
                return memo[start] = true;
        }
        return memo[start] = false;
    }
}*/
/*动态规划，将查找字符串拆分成子问题s1和s2，
s1:(0, j-1)
s2:(j, i)
* */
class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        // 为了方便递归,因此dp[i]表示在小标i之前的字符串是否满足条件
        boolean[] dp = new boolean[s.length() + 1];
        // 表示空字符串
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
