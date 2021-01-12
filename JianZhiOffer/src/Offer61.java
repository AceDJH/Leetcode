import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author AceDJH
 * @Date 2021/1/12 9:19
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 *
 * 限制：
 *
 * 数组长度为 5
 *
 * 数组的数取值为 [0, 13] .
 */
public class Offer61 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,6,5,4,2};
        System.out.println(new Solution61().isStraight(nums));
    }
}

class Solution61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int num0Count = 0;
        for (int num : nums) {
            if (num == 0){
                num0Count++;
            }
        }
        int sum = 0;
        for (int i = nums.length - 1; i > num0Count; i--) {
            if (nums[i] == nums[i - 1]){
                return false;
            }
            sum += nums[i] - nums[i - 1];
        }
/*        if (num0Count == 0){
            return sum == nums.length - 1;
        }else {
            int notNum0Count = nums.length - num0Count;
            return sum - (notNum0Count - 1) <= num0Count;
        }*/
        // 将上式简化
        return sum + 1 <= nums.length;
    }
}
// 题中已经明确数组长度为 5，因此不必增加难度，使用nums.length
// 根据题意，此 55 张牌是顺子的 充分条件 如下：
//
//         除大小王外，所有牌 无重复 ；
//         设此 55 张牌中最大的牌为 maxmax ，最小的牌为 minmin （大小王除外），则需满足：
//         max - min < 5
//         max−min<5
//
//         因而，可将问题转化为：此 55 张牌是否满足以上两个条件？
class Solution61Better{
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0){
                continue;
            }
            max = Math.max(num, max);
            min = Math.min(num, min);
            if (repeat.contains(num)){
                return false;
            }
            repeat.add(num);
        }
        return max - min < 5;
    }
}