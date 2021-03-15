/**
 * @Author AceDJH
 * @Date 2021/3/15 13:49
 */
public class Offer45New {
    public static void main(String[] args) {
        Offer45New offer45New = new Offer45New();
        int[] nums = new int[]{3, 30, 34, 5, 9};
        System.out.println(offer45New.minNumber(nums));
        System.out.println(offer45New.getMerge(3, 34));
        System.out.println(offer45New.getMerge(34, 3));;

    }
    public String minNumber(int[] nums) {
        if (nums == null){
            return null;
        }
        quickSort(nums, 0, nums.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    public void quickSort(int[] nums, int start, int end){
        if (start < end){
            int index = partition(nums, start, end);
            quickSort(nums, start, index - 1);
            quickSort(nums, index + 1, end);
        }
    }

    public int partition(int[] nums, int start, int end){
        int temp = nums[start];
        while (start < end){
            while (start < end && getMerge(temp, nums[end]) <= getMerge(nums[end], temp)){
                end--;
            }
            nums[start] = nums[end];
            while (start < end && getMerge(nums[start], temp) <= getMerge(temp, nums[start])){
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = temp;
        return start;
    }

    // a结合b,如20, 3 -> 203
    public long getMerge(int a, int b){
        if (b == 0){
            return a * 10L;
        }
        int digit = 1, tempb = b;
        while (tempb != 0){
            tempb /= 10;
            digit *= 10;
        }
        return (long) a * digit + b;
    }
}
