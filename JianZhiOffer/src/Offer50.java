import java.util.HashMap;
import java.util.Map;

/**
 * @Author AceDJH
 * @Date 2020/12/25 9:41
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 */
public class Offer50 {
    public static void main(String[] args) {
        System.out.println(new Solution50().firstUniqChar("abaccdeff"));
    }
}

// 在写到最后，发现根本不需要构造class，直接存true、false即可
// 但是这样做的话在遍历时就不能遍历hash，而应该使用字符串，与hash中对应的key和value进行判决
class Solution50 {
    static class CharIndex{
        char letter;
        int index;
        boolean isFirst;

        public CharIndex() {
        }

        public CharIndex(char letter, int index, boolean isFirst) {
            this.letter = letter;
            this.index = index;
            this.isFirst = isFirst;
        }
    }
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0){
            return ' ';
        }
        Map<Character, CharIndex> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            CharIndex charIndex = map.getOrDefault(s.charAt(i), null);
            if (charIndex == null){
                map.put(s.charAt(i), new CharIndex(s.charAt(i), i, true));
            }else {
                map.put(s.charAt(i), new CharIndex(s.charAt(i), i, false));
            }
        }
        int indexFirst = Integer.MAX_VALUE;
        char a = ' ';
        for (Character character : map.keySet()) {
            CharIndex temp = map.get(character);
            if (temp.isFirst){
                if (temp.index < indexFirst){
                    a = temp.letter;
                    indexFirst = temp.index;
                }
            }
        }
        return a;
    }
}

class SolutionNew50 {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }
}
