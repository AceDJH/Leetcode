package NiuKe;

/**
 * @Author AceDJH
 * @Date 2020/4/22 15:22
 */
public class Sheep {
    public int getAns(int[] A, int n) {
        // write code here
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] != (i + 1)) {
                sum++;
            }
        }
        return sum / 2;
    }
}
