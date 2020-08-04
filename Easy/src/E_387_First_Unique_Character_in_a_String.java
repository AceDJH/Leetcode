import java.util.HashMap;

/**
 * @Author AceDJH
 * @Date 2020/2/21 20:18
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 *  
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E_387_First_Unique_Character_in_a_String {
    public static void main(String[] args) {
        System.out.println(new Solution387().firstUniqChar("aa"));
    }
}

class Solution387 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), i + 1);
            else
                map.put(s.charAt(i), i);
        }
        int j = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == i) {
                j = i;
                break;
            }
        }
        return j;
    }
}
