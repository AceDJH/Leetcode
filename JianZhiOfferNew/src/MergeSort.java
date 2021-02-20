import java.util.Arrays;

/**
 * @Author AceDJH
 * @Date 2021/2/20 15:00
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {7,4,1,3,6,8,2,5,2};
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 元素分解
     * @param array
     * @param left
     * @param right
     * @param temp
     */
    public static void sort(int[] array, int left, int right, int[] temp){
        if (left < right){
            int mid = left + (right - left) / 2;
            sort(array, left, mid, temp);
            sort(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);
        }
    }

    /**
     * 元素合并
     * @param array
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void merge(int[] array, int left, int mid, int right, int[] temp){
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }
        int start = left;
        int j = mid + 1;
        while (left <= mid && j <= right){
            if (temp[left] <= temp[j]){
                array[start++] = temp[left++];
            }else {
                array[start++] = temp[j++];
            }
        }
        while (left <= mid){
            array[start++] = temp[left++];
        }
        while (j <= right){
            array[start++] = temp[j++];
        }
    }
}
