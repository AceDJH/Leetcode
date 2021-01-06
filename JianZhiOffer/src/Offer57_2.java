import java.util.ArrayList;
import java.util.List;

/**
 * @Author AceDJH
 * @Date 2021/1/6 15:38
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 */
public class Offer57_2 {
    public static void main(String[] args) {
        System.out.println(new Solution57_2().findContinuousSequence(9));
    }
}

class Solution57_2 {
    public Object findContinuousSequence(int target) {
        int[] nums = new int[target / 2 + 1];
        // 其实完全可以不创建数组，因为数组值和下标相关，直接使用下标就行
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        int small = 0, big = 1, sum = 0;
        List<int[]> lists = new ArrayList<>();
        sum += nums[small] + nums[big];
        while (small < nums.length - 1){
            if (sum == target){
                int[] arr = new int[big - small + 1];
                for (int i = small; i <= big; i++) {
                    arr[i - small] = nums[i];
                }
                lists.add(arr);
                sum -= nums[small];
                small++;
            }else if (sum < target){
                big++;
                sum += nums[big];
            }else {
                sum -= nums[small];
                small++;
            }
        }
        return lists.toArray(new int[lists.size()][]);
    }
}