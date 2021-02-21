import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author AceDJH
 * @Date 2021/2/21 13:16
 */
public class Offer40 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,0};
        System.out.println(Arrays.toString(new Solution40().getLeastNumbers(arr, 2)));
    }
}

class Solution40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null){
            return new int[0];
        }
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i : arr) {
            heap.add(i);
        }
        int[] nums = new int[k];
        int i = 0;
        while (i < k){
            nums[i++] = heap.poll();
        }
        return nums;
    }
}