/**
 * @Author AceDJH
 * @Date 2020/5/25 15:51
 * 面试题11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class Offer11 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 1};
        System.out.println(new Solution11().minArray(nums));
    }
}

class Solution11 {
    public int minArray(int[] numbers) {
        if (numbers.length <= 0) {
            throw new RuntimeException();
        }
        int left = 0;
        int right = numbers.length - 1;
        int mid = left;
        while (numbers[left] >= numbers[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = (left + right) / 2;
            if (numbers[left] == numbers[right] && numbers[left] == numbers[mid]) {
                int min = numbers[left];
                for (int i = left + 1; i <= right; i++) {
                    if (numbers[i] < min) {
                        min = numbers[i];
                        break;
                    }
                }
                return min;
            }
            if (numbers[mid] >= numbers[left]) {
                left = mid;
            }
            if (numbers[mid] <= numbers[right]) {
                right = mid;
            }
        }
        return numbers[mid];
    }
}



