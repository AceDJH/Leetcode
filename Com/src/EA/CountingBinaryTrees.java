package EA;

import java.util.Scanner;

/**
 * @Author AceDJH
 * @Date 2020/5/11 15:08
 * Counting Binary Trees
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * Given n nodes, how many shapes of binary tress can them form?
 * <p>
 * For example: If n = 1, there's only 1 type of binary tree.
 * <p>
 * If n=2, there are two types of binary trees:
 * <p>
 * and
 * <p>
 * If n =3, there are 5 types of binary trees
 * <p>
 * and
 * <p>
 * Please write a function, given N, output the result of tree shape count.
 * <p>
 * 输入
 * Input is a integer smaller than 30000, indicating how many nodes are there in the binary tree.
 * <p>
 * 输出
 * Output is a integer, indicating how many shapes of binary trees are there given the input node cound.
 * <p>
 * <p>
 * 样例输入
 * 3
 * 样例输出
 * 5
 * 数字太大，还应该化简
 */
// AC63
public class CountingBinaryTrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        long sum = 0;
        while (scanner.hasNextInt()) {
            num = scanner.nextInt();
            long a = JieCheng(2 * num);
            long b = JieCheng(num);
            long c = JieCheng(num + 1);
            sum = a / (b * c);
            System.out.println(sum);
        }
    }

    public static long JieCheng(int n) {
        long sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }
}
