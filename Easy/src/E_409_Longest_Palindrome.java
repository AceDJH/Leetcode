import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author AceDJH
 * @Date 2020/3/19 17:41
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class E_409_Longest_Palindrome {
    public static void main(String[] args) {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(new Solution409().longestPalindrome(s));
    }
}

class Solution409 {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> integerHashMap = new HashMap<>();
        // 统计数量时还可以直接使用数组来统计，cnt[c - 'A'] += 1
        for (int i = 0; i < s.length(); i++) {
            if (integerHashMap.containsKey(s.charAt(i))) {
                int num = integerHashMap.get(s.charAt(i));
                integerHashMap.put(s.charAt(i), ++num);
            } else {
                integerHashMap.put(s.charAt(i), 1);
            }
        }
        int oddNum = 0, evenNum = 0;
        boolean haveOdd = false;
        Set<Character> characters = integerHashMap.keySet();
        for (Character character : characters) {
            int num = integerHashMap.get(character);
            if (num % 2 == 0) {
                evenNum += num;
            } else {
                haveOdd = true;
                // 字母个数为奇数，可以少抽取一个，这样它就变为偶数，可以做回文。
                oddNum = oddNum + num - 1;
            }
        }
        int num = evenNum + oddNum;
        // 若是有奇数的话，可以将其放在中间，因此补一
        return haveOdd ? num + 1 : num;
    }
}


