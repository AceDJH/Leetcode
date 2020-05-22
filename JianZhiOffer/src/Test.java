/**
 * @Author AceDJH
 * @Date 2020/5/22 12:00
 */
public class Test{
    public static void main(String[] args) {
        System.out.println(sumRecursive(5));
    }

    // 递归
    public static int sumRecursive(int n){
        if (n <= 0){
            return 0;
        }
        return n + sumRecursive(n - 1);
    }
}

