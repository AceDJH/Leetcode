package mhy;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author AceDJH
 * @date 2021/9/12 9:36 下午
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] nums = new int[t];
        int i = 0;
        while (i < t){
            String s = scanner.next();
            nums[i] = getCount(s);
            i++;
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static int getCount(String s){
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char aChar : chars) {
            if (aChar == '[' || aChar == '{') {
                stack.push(aChar);
            }
            if (aChar == ']') {
                Character pop = stack.pop();
                if (pop != '[') {
                    count++;
                }
            }
            if (aChar == '}') {
                Character pop = stack.pop();
                if (pop != '{') {
                    count++;
                }
            }
        }
        return count;
    }
}
