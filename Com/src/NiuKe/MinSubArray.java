package NiuKe;

/**
 * @Author AceDJH
 * @Date 2020/4/22 13:12
 * 算法--求需要排序的最短子数组问题
 * https://www.cnblogs.com/haozhengfei/p/41f817879b5c800789faabb52fb2eeec.html
 */
public class MinSubArray {
    public int shortestSubsequence(int[] A, int n) {
        //假定最大值,最小值
        int max = A[0];
        int min = A[A.length - 1];
        //i和j之间的范围便是需要排序的最短子数组(一开始假定全部范围)
        int p = 0, q = A.length - 1;
        /**
         * 从右向左遍历，找出不合适数的最右范围
         * (遍历过部分的最大值大于当前正在遍历的值,那么当前值就是invalid,那么真实排序之后,这个最大值在当前位置,或者是更右的位置)
         *
         * 只记录发生这种情况的最右位置
         */
        for (int i = 1; i < A.length; i++) {
            if (max > A[i]) p = i;
            else max = A[i];
        }
        /**
         * 从左向右遍历，找出不合适数的最左范围
         * (遍历过部分的最小值小于当前正在遍历的值,那么当前值就是invalid,那么真实排序之后,这个最小值在当前位置,或者是更左的位置)
         *
         * 只记录发生这种情况的最左位置
         */
        for (int i = A.length - 2; i > -1; i--) {
            if (min < A[i]) q = i;
            else min = A[i];
        }
        if (p == 0 && q == A.length - 1) {
            return 0;//证明原数组是有序的
        }
        return p - q + 1;
    }
}
