/**
 * @Author AceDJH
 * @Date 2020/2/17 18:28
 * 231. 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 */
public class E_231_Powe_o_Two {
    public static void main(String[] args) {
        System.out.println(7 / 2); // 3
        System.out.println(Solution231.isPowerOfTwo(1));
    }
}

/*我的写法
class Solution231 {
    public static boolean isPowerOfTwo(int n) {
        if (n == 1){
            return true;
        }
        while(n % 2 == 0 && n != 0){
            n /= 2;
            if (n == 1){
                return true;
            }
        }
        return false;
    }
}*/

//官方给的写法，思想相同但是更加简洁
class Solution231 {
    public static boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        while (n % 2 == 0)
            n /= 2;
        return n == 1;
    }
}
