/**
 * @Author AceDJH
 * @Date 2020/7/15 22:06
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 */
public class Offer17 {
    public static void main(String[] args) {
        System.out.println(new Solution17().printNumbers(2));
    }
}
/*由于leetcode上返回的为int数组，因此可以直接通过数字解决
class Solution17 {
    public int[] printNumbers(int n) {
        if (n <= 0){
            return null;
        }
        int max = (int) Math.pow(10, n) - 1;
        int[] nums = new int[max];
        for (int i = 0; i < max; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }
}*/

// 剑指offer书中提到考虑大数问题，想要表示大数，字符串就很有效
class Solution17 {
    int[] res;
    // start和nine的作用是删除左边多余的0
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers(int n) {
        if (n <= 0){
            return null;
        }
        this.n = n;
        res = new int[(int) (Math.pow(10, n) - 1)];
        // 定义长度为 n 的字符列表
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }

    void dfs(int x) {
        // 终止条件：已固定完所有位
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")){
                res[count++] = Integer.parseInt(s);
            }
            if (n - start == nine) {
                start--;
            }
            return;
        }
        for (char c : loop) {
            if (c == '9'){
                nine++;
            }
            // 固定第 x 位为 i
            num[x] = c;
            dfs(x + 1);
        }
        nine--;
    }
}