import java.util.Stack;
import java.util.concurrent.TransferQueue;

/**
 * @Author AceDJH
 * @Date 2020/4/13 21:57
 * 402. 移掉K位数字
 * 贪心算法
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * <p>
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 * <p>
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * <p>
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 * <p>
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MW_402_Remove_K_Digits {
    public static void main(String[] args) {
        int a = '3' - '0';
        String b = "002";
        System.out.println(b.charAt(0) == '0');
    }
}

/**
 * 关键难点在于问题的简化，通过抽象将问题分层，分步解决，而不是混在一块将问题越想越乱。
 */
class Solution402 {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : num.toCharArray()) {
            while (stack.size() > 0 && k > 0 && c < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        for (int i = 0; i < k; i++) {
            stack.pop();
        }
        StringBuilder nums = new StringBuilder();
        boolean isFirstZero = true;
        for (Character character : stack) {
            if (isFirstZero && character == '0') {
                continue;
            }
            isFirstZero = false;
            nums.append(character);
        }
        // 因为有可能会出现栈中全为0的情况
        if (nums.length() == 0) {
            return "0";
        }
        return nums.toString();
    }
}