package xiaomi;

import java.util.Scanner;

/**
 * @author AceDJH
 * @date 2021/9/8 7:51 下午
 * 红白蓝彩条排序
 * 给你一个仅有红，白，蓝三种颜色组成的10个条块序列，现需要你将这些条块按照红，白，蓝的顺序排好，可用1代表红色，2代表白色，3代表蓝色，要求时间复杂度为O(n)。例如，给定彩色条块序列为：
 *
 * ｛蓝、白、红、白、蓝、红、白、白、红、蓝｝
 *
 * 则要求排列结果为：
 *
 * ｛红、红、红、白、白、白、白、蓝、蓝、蓝｝
 *
 *
 *
 * 输入描述
 * ｛蓝、白、红、白、蓝、红、白、白、红、蓝｝
 *
 * 输出描述
 * ｛红、红、红、白、白、白、白、蓝、蓝、蓝｝
 *
 *
 * 样例输入
 * 3 2 1 2 3 1 2 2 1 3
 * 样例输出
 * 1 1 1 2 2 2 2 3 3 3
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = sc.nextInt();
        }
        sortNums(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void sortNums(int[] nums){
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
                start++;
            }
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
                start++;
            }
        }
    }
}
