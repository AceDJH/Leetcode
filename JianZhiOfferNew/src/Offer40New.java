

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

/*class Solution40New {
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
}*/

class Solution40New {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0){
            return new int[]{};
        }
        int[] nums = new int[k];
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
        if (k >= 0) {
            System.arraycopy(arr, 0, nums, 0, k);
        }
        return nums;
    }

    public int partition(int[] arr, int start, int end){
        int temp = arr[start];
        while (start < end){
            while (start < end && arr[end] >= temp){
                end--;
            }
            arr[start] = arr[end];
            while (start < end && arr[start] <= temp){
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = temp;
        return start;
    }
}
