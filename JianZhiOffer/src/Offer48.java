import java.util.HashMap;

/**
 * @Author AceDJH
 * @Date 2020/12/23 21:35
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 *
 * 提示：
 *
 * s.length <= 40000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer48 {
    public static void main(String[] args) {
        // HashMap<Character, Boolean> map = new HashMap<>(30);
        // map.put('c', true);
        // System.out.println(map.get('c'));
        System.out.println(new Solution48().lengthOfLongestSubstring("dvdf"));
    }
}

class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, sum = 0;
        int start = 0;
        HashMap<Character, Boolean> map = new HashMap<>(30);
        int i = 0;
        while (i < s.length()){
            Boolean result = map.getOrDefault(s.charAt(i), null);
            if (result == null){
                map.put(s.charAt(i), true);
                sum++;
                i++;
                if (sum > max){
                    max = sum;
                }
            }else {
                start++;
                i = start;
                sum = 0;
                map = new HashMap<>(30);
            }
        }
        return max;
    }
}