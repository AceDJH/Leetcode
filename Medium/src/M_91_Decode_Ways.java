import java.util.Arrays;

/**
 * @Author AceDJH
 * @Date 2020/3/18 16:48
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class M_91_Decode_Ways {
    public static void main(String[] args) {
        // System.out.println('Z' - '0');
        String s = "32";
        System.out.println(s.charAt(0));
        System.out.println(s.charAt(0) - '0');
        if (s.charAt(0) - '0' == 3)
            System.out.println("lalalla");
        System.out.println(new Solution91().numDecodings("12"));
    }
}

class Solution91 {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        if (s.length() == 1)
            return 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0' && (s.charAt(i - 1) > '2' || s.charAt(i - 1) == '0'))
                return 0;
        }
        s = s.replaceAll("10", "Z");
        s = s.replaceAll("20", "Z");
        if (s.length() == 1)
            return 1;
        int[] nums = new int[s.length()];
        Arrays.fill(nums, 1);
        // 另一种转为int的办法：char -> String -> Integer.parseInt(String)
        // Integer.parseInt(String.valueOf(s.charAt(1)));
        if ((s.charAt(1) - '0' <= 9 && s.charAt(1) - '0' >= 1 && s.charAt(0) - '0' == 1) ||
                (s.charAt(1) - '0' <= 6 && s.charAt(1) - '0' >= 1 && s.charAt(0) - '0' == 2))
            nums[1] = 2;
        for (int i = 2; i < s.length(); i++) {
            if ((s.charAt(i) - '0' <= 9 && s.charAt(i) - '0' >= 1 && s.charAt(i - 1) - '0' == 1) ||
                    (s.charAt(i) - '0' <= 6 && s.charAt(i) - '0' >= 1 && s.charAt(i - 1) - '0' == 2))
                nums[i] = nums[i - 1] + nums[i - 2];
            else
                nums[i] = nums[i - 1];
        }
        return nums[s.length() - 1];
    }
}
