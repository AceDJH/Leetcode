import java.util.HashSet;
import java.util.Set;

/**
 * @Author AceDJH
 * @Date 2020/2/23 21:30
 * 202. 快乐数
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E_202_Happy_Number {
}

/*class Solution202 {
    public boolean isHappy(int n) {
        if (n < 0)
            return false;
        HashSet<Integer> integers = new HashSet<>();
        while (true){
            int num = squareSum(n);
            if (integers.contains(num))
                return false;
            else if (num == 1){
                return true;
            }else {
                integers.add(num);
            }
            n = num;
        }
    }

    public int squareSum(int n){
        int sum = 0;
        while(n > 0){
            int num = n % 10;
            n /= 10;
            sum += num * num;
        }
        return sum;
    }
}*/

/*另一种破除循环的做法是使用快慢指针（给解题区大佬跪了）
思想是：使用“快慢指针”思想找出循环：“快指针”每次走两步，“慢指针”每次走一步，当二者相等时，即为一个循环周期。
* */
class Solution202 {
    public boolean isHappy(int n) {
        if (n < 0)
            return false;
        int slow = n, fast = n;
        do{
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        }while (slow != fast);
        return slow == 1;
    }

    public int squareSum(int n){
        int sum = 0;
        while(n > 0){
            int num = n % 10;
            n /= 10;
            sum += num * num;
        }
        return sum;
    }
}