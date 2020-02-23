import java.util.ArrayList;

/**
 * @Author AceDJH
 * @Date 2020/2/23 15:31
 * 326. 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 * 示例 4:
 *
 * 输入: 45
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E_326_Power_of_Three {
    public static void main(String[] args) {
        System.out.println(new Solution326().isPowerOfThree(6));
        System.out.println(Integer.MAX_VALUE);
    }
}

/*利用循环
class Solution326 {
    public boolean isPowerOfThree(int n) {
        while (n > 0){
            if (n == 1)
                return true;
            if (n % 3 == 0)
                n /= 3;
            else
                return false;
        }
        return false;
    }
}*/

/*方法四：整数限制
* 官网给的题解，也是有想法
* 我有想到3的幂次是有限的，可穷尽，但是想法却是将得到的n和这些幂进行对比，
* 仍然需要循环。
* 而这种方法利用数学性质，很简洁
*我们可以看出 n 的类型是 int。在 Java 中说明了该变量是四个字节，他的最大值为 2147483647。有三种方法可以计算出该最大值。

Google
System.out.println(Integer.MAX_VALUE);
手动计算
*
* */
class Solution326 {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}