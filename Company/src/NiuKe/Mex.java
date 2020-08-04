package NiuKe;

import java.util.*;

/**
 * @Author AceDJH
 * @Date 2020/4/22 14:53
 */

public class Mex {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 5, 6, 3, 2};
        System.out.println(new Mex().getMex(A, 7));
    }

    public int getMex(int[] A, int n) {
        // write code here
        Arrays.sort(A);
        for (int i = 0; i < n; i++) {
            if (A[i] + 1 == A[i + 1] || A[i] == A[i + 1]) {
                continue;
            }
            return A[i] + 1;
        }
        return A[n - 1] + 1;
    }
}
