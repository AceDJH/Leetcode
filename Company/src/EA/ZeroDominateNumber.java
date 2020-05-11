package EA;

import java.util.Scanner;

/**
 * @Author AceDJH
 * @Date 2020/5/11 15:28
 * Zero Dominate Number
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * Given a number n and convert it to binary representation, if there are as many or more zeros than it has ones, the number is could a "ZeroDominateNumber", abbreviation as ZDN. For example, binary form of number ten is 1010; as there are two zeros and two ones, ten is a ZDN; binary form of number 27 is 11011, since it has two zeros and three ones, it's not a ZDN.
 *
 * Given a start number and an end number, please write a function to output number of ZDN's between them (1 ≤ Start < Finish ≤ 2000000000).
 *
 * 输入
 * Two comma-separated integers, respectively Start and Finish
 *
 * 输出
 * A single integer indicating the cound of ZDN in the inclusive range [Start...Finish]
 *
 *
 * 样例输入
 * 2,12
 * 样例输出
 * 6
 */
// AC63
public class ZeroDominateNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String a = scanner.nextLine().trim();
            String[] array = a.split(",");
            int start = Integer.parseInt(array[0]);
            int end = Integer.parseInt(array[1]);
            int sum = sumZDN(start, end);
            System.out.println(sum);
        }
    }

    public static int sumZDN(int start, int end){
        int sumzdn = 0;
        for (int i = start; i <= end; i++){
            String s = Integer.toBinaryString(i);
            int sum1 = s.length() % 2 == 0 ? s.length() / 2 : (s.length() + 1) / 2;
            int sum0 = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0'){
                    sum0++;
                }
                if (sum0 >= sum1){
                    break;
                }
            }
            if (sum0 >= sum1){
                sumzdn++;
            }
        }
        return sumzdn;
    }
}
