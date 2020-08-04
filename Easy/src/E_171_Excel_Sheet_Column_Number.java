/**
 * @Author AceDJH
 * @Date 2020/2/26 21:36
 * 171. Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1:
 * <p>
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: "ZY"
 * 输出: 701
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E_171_Excel_Sheet_Column_Number {
    public static void main(String[] args) {
        System.out.println('Z' - 'A');
        System.out.println(new Solution171().titleToNumber("ABC"));
    }
}

/*我的这种方法是纯粹的数学分析后得到
* 在解题区看到另一种思路方式不错，记录下来
*
class Solution171 {
    public int titleToNumber(String s) {
        int seq = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.length() - i - 1;
            int count = (int) Math.pow(26, num) * (s.charAt(i) - 'A' + 1);
            seq += count;
        }
        return  seq;
    }
}*/
// 看作26进制
// 对于理解进制很有帮助
class Solution171 {
    public int titleToNumber(String s) {
        int seq = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            seq = seq * 26 + num;
        }
        return seq;
    }
}