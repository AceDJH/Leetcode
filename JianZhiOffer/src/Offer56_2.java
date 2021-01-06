import java.util.HashMap;
import java.util.Map;

/**
 * @Author AceDJH
 * @Date 2021/1/4 11:17
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 *
 *
 * 限制：
 *
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 */
public class Offer56_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 4, 3};
        System.out.println(new Solution56_2Better2().singleNumber(nums));
    }
}

class Solution56_2 {
    Map<Integer, Integer> map = new HashMap<>();
    public int singleNumber(int[] nums) {
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num, ++count);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return 0;
    }
}

// 有限状态机
class Solution56_2Better {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}

// 位统计
class Solution56_2Better2 {
    public int singleNumber(int[] nums) {
        int intLength = 32;
        int[] counts = new int[intLength];
        for (int num : nums) {
            for (int i = 0; i < intLength; i++) {
                counts[i] += num & 1;
                num = num >>> 1;
            }
        }
        int result = 0;
        for (int i = 0; i < intLength; i++) {
            result = result << 1;
            result = result | counts[31 - i] % 3;
        }
        return result;
    }
}
