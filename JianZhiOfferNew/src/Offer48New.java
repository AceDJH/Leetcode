import java.util.HashMap;
import java.util.Map;

/**
 * @Author AceDJH
 * @Date 2021/3/16 10:03
 */
public class Offer48New {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer index = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i);
            if (i - index > temp){
                temp++;
            }else {
                temp = i - index;
            }
            max = Math.max(max, temp);
        }
        return max;
    }
}
