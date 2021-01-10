import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author AceDJH
 * @Date 2021/1/10 9:53
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 */
public class Offer59_1 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] window = new Solution59_1().maxSlidingWindow(nums, 3);
        for (int i : window) {
            System.out.print(i + " ");
        }
    }
}


class Solution59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0){
            return nums;
        }
        int max = nums[0];
        int index = 0;
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            if (nums[i] >= max){
                max = nums[i];
                index = i;
            }
        }
        for (int i = 0; i <= nums.length - k; i++) {
            if (index >= i && index <= i + k - 1){
                if (nums[i + k - 1] >= max){
                    max = nums[i + k - 1];
                    index = i + k - 1;
                }
            }else {
                max = nums[i];
                index = i;
                for (int j = 0; j < k; j++) {
                    if (nums[i + j] >= max){
                        max = nums[i + j];
                        index = i + j;
                    }
                }
            }
            res[i] = max;
        }
        return res;
    }
}

class Solution59_1Better {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0){
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        // 将left设置为1-k，则不需要像之前的算法一样，使用for单独处理
        for (int left = 1 - k, right = 0; right < nums.length; left++, right++){
            if (left > 0 && deque.peekFirst() == nums[left - 1]){
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[right]){
                deque.removeLast();
            }
            deque.addLast(nums[right]);
            if (left >= 0){
                res[left] = deque.peekFirst();
            }
        }
        return res;
    }
}