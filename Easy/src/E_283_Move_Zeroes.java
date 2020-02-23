/**
 * @Author AceDJH
 * @Date 2020/2/23 16:11
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E_283_Move_Zeroes {
}

/*用两个循环，第一个循环先把数提到前面，第二个在末尾补0
class Solution283 {
    public void moveZeroes(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                nums[num++] = nums[i];
        while (num < nums.length)
            nums[num++] = 0;
    }
}*/

/*在题解区看到一个思想一样但是更简洁的
    在提了后，直接将那一位置为0
* */
class Solution283 {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count++;
            else if (count > 0){//此处必须加判断，否则[1]就不会通过
                nums[i - count] = nums[i];
                nums[i] = 0;
            }
        }
    }
}


