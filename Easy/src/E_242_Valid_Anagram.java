import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author AceDJH
 * @Date 2020/3/5 23:10
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E_242_Valid_Anagram {
    public static void main(String[] args) {
        System.out.println(new Solution242().isAnagram("aacc", "ccaa"));
    }
}

/*
class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> snums = new HashMap<>();
        Map<Character, Integer> tnums = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (snums.containsKey(s.charAt(i))){
                Integer integer = snums.get(s.charAt(i));
                snums.put(s.charAt(i), ++integer);
            }else {
                snums.put(s.charAt(i), 1);
            }
            if (tnums.containsKey(t.charAt(i))){
                Integer integer = tnums.get(t.charAt(i));
                tnums.put(t.charAt(i), ++integer);
            }else{
                tnums.put(t.charAt(i), 1);
            }
        }
*/
/*        for (Character character : snums.keySet()){
            Integer integer = snums.get(character);
            System.out.println("snums : " + character + integer);
        }
        for (Character character : tnums.keySet()){
            Integer integer = tnums.get(character);
            System.out.println("tnums : " + character + integer);
        }*//*

        return snums.equals(tnums);
    }
}*/
class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        return Arrays.equals(chars, chart);
    }
}
