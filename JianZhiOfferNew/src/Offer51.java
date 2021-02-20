/**
 * @Author AceDJH
 * @Date 2021/2/18 21:30
 */
public class Offer51 {
    public static void main(String[] args) {
        int[] nums = new int[]{7,5,6,4};
        System.out.println(new Solution51().reversePairs(nums));
    }
}

class Solution51 {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        int[] temp = new int[nums.length];
        return sort(nums, 0, nums.length - 1, temp);
    }

    /**
     * 元素分解
     * @param array
     * @param left
     * @param right
     * @param temp
     */
    public static int sort(int[] array, int left, int right, int[] temp){
        if (left < right){
            int mid = left + (right - left) / 2;
            int leftCount = sort(array, left, mid, temp);
            int rightCount = sort(array, mid + 1, right, temp);
            if (array[mid] <= array[mid + 1]){
                return leftCount + rightCount;
            }
            int crossCount = merge(array, left, mid, right, temp);
            return leftCount + rightCount + crossCount;
        }
        return 0;
    }

    /**
     * 元素合并
     * @param array
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static int merge(int[] array, int left, int mid, int right, int[] temp){
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }
        int count = 0;
        int start = left;
        int j = mid + 1;
        while (left <= mid && j <= right){
            if (temp[left] <= temp[j]){
                array[start++] = temp[left++];
            }else {
                array[start++] = temp[j++];
                // 因为左右数组各自来看都是已经排好序的，因此右数组中一个数字小于左数组中的某个数字，
                // 意味着小于左数组中该数字右侧的全部数
                count += (mid - left + 1);
            }
        }
        while (left <= mid){
            array[start++] = temp[left++];
        }
        while (j <= right){
            array[start++] = temp[j++];
        }
        return count;
    }
}