import java.util.HashSet;

/**
 * @Author AceDJH
 * @Date 2020/5/8 20:53
 * 面试题03. 数组中重复的数字
 */
public class Offer3 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 0, 4, 5, 6, 7, 8, 9};
        System.out.println(new Solution3().findRepeatNumber(nums));
    }
}

/*使用集合
时间复杂度O(n)
空间复杂度O(n)
class Solution3 {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)){
                return num;
            }
            hashSet.add(num);
        }
        return -1;
    }
}*/

/*利用数组下标对应数字
时间复杂度O(n)
空间复杂度O(1)
**/
class Solution3 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;
    }
}

/*书中给出的这种二分法解答有问题
eg：[0, 1, 2, 0, 4, 5, 6, 7, 8, 9]
按照书中所言0-4若有重复，则count>5，而在这个数组中有0这个重复，但是count为5，没有超过5，
因此判定没有重复，但原因是数组中没有3，相当于用0占据了3的位置
在仔细研究后，发现书中解法是对的，但是要求很严苛
书中是长度为n+1的数组中，数字在1-n的范围内,也即数字种类为n种,小于长度
而这个例子：长度为10，数字种类也为10，等于长度，因此不能使用
class Solution3 {
    public int findRepeatNumber(int[] nums) {
        if (nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (end >= start){
            int middle = (end - start) / 2 + start;
            int count = countRange(nums, start, middle);
            if (end == start){
                if (count > 1){
                    return start;
                }
                else {
                   break;
                }
            }

            if (count > (middle - start + 1)){
                end = middle;
            }
            else {
                start = middle + 1;
            }
        }
        return -1;
    }

    public int countRange(int[] nums, int start, int end){
        if (nums.length == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= start && nums[i] <= end){
                ++count;
            }
        }
        return count;
    }
}*/
