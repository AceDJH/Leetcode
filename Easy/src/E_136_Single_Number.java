import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author AceDJH
 * @Date 2020/2/18 12:25
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E_136_Single_Number {
}

/*class Solution136 {
    public int singleNumber(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        Arrays.sort(nums);
        if (nums[nums.length - 1] != nums[nums.length - 2])
            return nums[nums.length - 1];
        for (int i = 0; i < nums.length -1; i+=2) {
            if (nums[i] != nums[i + 1]){
                return nums[i];
            }
        }
        throw new RuntimeException();
    }
}*/

 /*官方给的位操作，有点厉害
 * 利用异或的特性，一个数同自己异或结果为0
 * 同0异或为自己
 * 异或运算满足交换律，a^b^a=a^a^b=b
 *
class Solution136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}*/

// 使用hashmap存储
class Solution136 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, 2);
            }
        }
        for (int num : nums) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        throw new RuntimeException();
    }
}