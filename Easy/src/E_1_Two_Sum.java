import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author AceDJH
 * @Date 2020/2/15 15:48
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class E_1_Two_Sum {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        System.out.println(Arrays.toString(Solution1.twoSum(nums, 6)));
    }
}

/*1、暴力法
class Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] numbers = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    numbers[0] = i;
                    numbers[1] = j;
                    break;
                }
            }
        }
        return numbers;
    }
}*/

/*2、两遍哈希表
class Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num) && map.get(num) != i){
                int index = map.get(num);
                return new int[]{i, index};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}*/

/*3、一遍哈希表:
eg:
    ([2,3,4,5]. 8), 虽然过3的时候不能检测出来，但是在过5的时候，3已经在hashMap中，可以检测出
    即 3 + 5 = 8， 5 + 3 = 8
 */
class Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

