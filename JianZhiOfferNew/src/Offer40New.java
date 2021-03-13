import java.util.PriorityQueue;

/**
 * @Author AceDJH
 * @Date 2021/3/13 15:33
 */
public class Offer40New {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1};
        System.out.println(new Solution40New().getLeastNumbers(nums, 2));
    }
}

class Solution40New {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0){
            return new int[]{};
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        int[] nums = new int[k];
        int i = 0;
        while (i < k){
            nums[i++] = queue.poll();
        }
        return nums;
    }
}
