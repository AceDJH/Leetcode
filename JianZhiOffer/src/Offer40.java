import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author AceDJH
 * @Date 2020/5/18 22:23
 * 面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class Offer40 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};
        new Solution40().getLeastNumbers(nums, 2);
    }
}

/*解法一：利用快排的部分思想，时间复杂度O(n)，需要修改输入数组
class Solution40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] nums = new int[k];
        if (arr.length == 0 || k == 0){
            return nums;
        }
        int start = 0, end = arr.length - 1;
        int index = partition(arr, start, end);
        while (index != k - 1){
            if (index > k - 1){
                end = index - 1;
                index = partition(arr, start, end);
            }else {
                start = index + 1;
                index = partition(arr, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            nums[i] = arr[i];
        }
        return nums;
    }

    // 快排中进行划分的函数
    public int partition(int[] nums, int start, int end){
        if (nums.length <= 0 || start < 0 || end >= nums.length){
            throw new RuntimeException();
        }
        int temp = nums[start];
        while (start < end){
            while (start < end && nums[end] >= temp){
                --end;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= temp){
                ++start;
            }
            nums[end] = nums[start];
        }
        nums[start] = temp;
        return start;
    }
}*/
// 解法二：使用大根堆，适合海量数据
class Solution40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0){
            return new int[0];
        }
        // 默认是小根堆，修改比较器，变为大根堆
        Queue<Integer> heap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i : arr) {
            if (heap.size() < k){
                heap.add(i);
            }else if (heap.peek() > i){
                heap.poll();
                heap.add(i);
            }
        }
        int[] nums = new int[k];
        for (int i = 0; i < k; i++){
            nums[i] = heap.poll();
        }
        return nums;
    }
}