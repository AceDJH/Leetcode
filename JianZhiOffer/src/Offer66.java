/**
 * @Author AceDJH
 * @Date 2021/1/14 11:21
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 *
 * 提示：
 *
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 */
public class Offer66 {
}

class Solution66 {
    public int[] constructArr(int[] a) {
        if (a == null || a.length < 1){
            return a;
        }
        int multiSum = 1;
        for (int j : a) {
            multiSum *= j;
        }
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0){
                int sum = 1;
                for (int j = 0; j < a.length; j++) {
                    if (j != i){
                        sum *= a[j];
                    }
                }
                b[i] = sum;
            }else {
                b[i] = multiSum / a[i];
            }
        }
        return b;
    }
}
class Solution66Normal {
    public int[] constructArr(int[] a) {
        if (a == null || a.length < 1){
            return a;
        }
        int[] b = new int[a.length];
        b[0] = 1;
        int temp = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for (int i = a.length - 2; i >= 0; i--){
            temp *= a[i + 1];
            b[i] *= temp;
        }
        return b;
    }
}
