/**
 * @Author AceDJH
 * @Date 2020/5/18 21:33
 * 面试题39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 50000
 */
public class Offer39 {

}

class Solution39 {
/*解法1：基于partition函数的时间复杂度为O(n)的算法
    public int majorityElement(int[] nums) {
        if (nums.length <= 0){
            throw new RuntimeException();
        }
        int middle = nums.length / 2;
        int start = 0, end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != middle){
            if (index > middle){
                end = index - 1;
                index = partition(nums, start, end);
            }else {
                start = start + 1;
                index = partition(nums, start, end);
            }
        }
        return nums[middle];
    }

    // 快排中进行划分的函数
    public int partition(int[] nums, int start, int end){
        if (nums.length <= 0 || start < 0 || end >= nums.length){
            throw new RuntimeException();
        }
        int temp = nums[start];
        while (start < end){
            while (start < end && nums[end] >= temp){
                --end;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= temp){
                ++start;
            }
            nums[end] = nums[start];
        }
        nums[start] = temp;
        return start;
    }*/

// 解法2：利用数组特点
    public int majorityElement(int[] nums) {
        if (nums.length <= 0){
            throw new RuntimeException();
        }
        int result = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++){
            if (times == 0){
                result = nums[i];
                times = 1;
            }else if (nums[i] == result){
                times++;
            }else {
                times--;
            }
        }
        return result;
    }
}
