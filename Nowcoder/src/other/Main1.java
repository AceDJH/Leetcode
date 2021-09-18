package other;

import java.util.Scanner;

/**
 * @author AceDJH
 * @date 2021/9/15 7:21 下午
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < n; i++) {
            if(sum >= 0){
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
