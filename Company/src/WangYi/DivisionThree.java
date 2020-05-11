package WangYi;

import java.util.Scanner;

/**
 * @Author AceDJH
 * @Date 2020/5/10 22:47
 * https://www.nowcoder.com/practice/51dcb4eef6004f6f8f44d927463ad5e8?tpId=98&tqId=32825&tPage=1&rp=1&ru=%2Fta%2F2019test&qru=%2Fta%2F2019test%2Fquestion-ranking
 */
/*ac通过
public class DivisionThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int left, right;
        while (scanner.hasNextInt()){
            left = scanner.nextInt();
            right = scanner.nextInt();
            int num = 0;
            for (int i = 1; i < left; i++){
                num = num * 10 + i;
            }
            int sum = 0;
            for (int i = left; i <= right; i++){
                if (num < 12345678){
                    num = num * 10 + i;
                }else{
                    num = num * 100 + i;
                }

                if (num % 3 == 0){
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
}*/
/*ac0%
public class DivisionThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int left, right;
        left = scanner.nextInt();
        right = scanner.nextInt();
        int num = 0;
        for (int i = 1; i < left; i++) {
            num = num * 10 + i;
        }
        int sum = 0;
        for (int i = left; i <= right; i++) {
            if (num < 12345678) {
                num = num * 10 + i;
            } else {
                num = num * 100 + i;
            }

            if (num % 3 == 0) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}*/

