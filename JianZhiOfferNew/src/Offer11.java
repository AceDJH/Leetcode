/**
 * @Author AceDJH
 * @Date 2021/2/9 10:54
 */
public class Offer11 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 1, 3};
        System.out.println(new Solution11().minArray(nums));
    }
}

class Solution11 {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length <= 0){
            return -1;
        }
        // left找左边最大的
        int left = 0;
        // right找右边最小的
        int right = numbers.length - 1;
        int mid = left;
        while (numbers[left] >= numbers[right]){
            if (right - left <= 1){
                mid = right;
                break;
            }
            // 为了防止头尾数值相同的情况，如{3, 3, 1, 3}
            if (numbers[left] == numbers[right] && numbers[left] == numbers[right]){
                int min = numbers[left];
                for (int i = left + 1; i <= right; i++){
                    if (numbers[i] <= min){
                        min = numbers[i];
                    }
                }
                return min;
            }
            mid = (left + right) / 2;
            if (numbers[mid] >= numbers[left]){
                left = mid;
            }
            if (numbers[mid] <= numbers[right]){
                right = mid;
            }
        }
        return numbers[mid];
    }
}
