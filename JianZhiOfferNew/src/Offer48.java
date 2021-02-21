import java.util.HashMap;
import java.util.Map;

/**
 * @Author AceDJH
 * @Date 2021/2/21 21:20
 */
public class Offer48 {
    public static void main(String[] args) {
        System.out.println(new Solution48().lengthOfLongestSubstring("pwwkew"));
    }
}

class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, sum = 0;
        Map<Character, Integer> map = new HashMap<>(26);
        for (int i = 0; i < s.length(); i++) {
            Integer index = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i);
            if (i - index > sum){
                sum++;
            }else {
                sum = i - index;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}