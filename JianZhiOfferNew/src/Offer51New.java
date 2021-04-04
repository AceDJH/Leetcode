/**
 * @Author AceDJH
 * @Date 2021/3/30 8:59
 */
public class Offer51New {
    
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        int[] temp = new int[nums.length];
        return sort(nums, 0, nums.length - 1, temp);
    }

    public int sort(int[] array, int left, int right, int[] temp){
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

    public int merge(int[] array, int left, int mid, int right, int[] temp){
        for (int i = left; i <= right; i++){
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
