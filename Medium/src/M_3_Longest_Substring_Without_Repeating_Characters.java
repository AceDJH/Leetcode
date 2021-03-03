import java.util.HashMap;
import java.util.Map;

/**
 * @Author AceDJH
 * @Date 2021/3/3 17:30
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class M_3_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("abcabcbb"));
    }
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, distance = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer num = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i);
            distance = i - num;
            if (distance <= temp){
                temp = distance;
            }else {
                temp++;
            }
            max = Math.max(temp, max);
        }
        return max;
    }
}