import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author AceDJH
 * @Date 2021/4/8 9:00
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class M_15_3Sum {
    /*三重for循环直接超出时间限制
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j){
                    int temp = nums[i] + nums[j];
                    for (int k = 0; k < nums.length; k++) {
                        if (k != i && k != j){
                            if (temp + nums[k] == 0){
                                List<Integer> a = new ArrayList<>();
                                int[] cur = new int[3];
                                cur[0] = nums[i];
                                cur[1] = nums[j];
                                cur[2] = nums[k];
                                Arrays.sort(cur);
                                a.add(cur[0]);
                                a.add(cur[1]);
                                a.add(cur[2]);
                                if (!res.contains(a)){
                                    res.add(a);
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }*/

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == 0){
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[left]);
                    cur.add(nums[right]);
                    res.add(cur);
                    while (left < right && nums[left] == nums[left + 1]){
                        left += 1;
                    }
                    while (left < right && nums[right] == nums[right - 1]){
                        right -= 1;
                    }
                    left += 1;
                    right -= 1;
                }
                if (temp > 0){
                    right--;
                }
                if (temp < 0){
                    left++;
                }
            }
        }
        return res;
    }
}
