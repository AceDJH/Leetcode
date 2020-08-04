import java.util.ArrayList;
import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/4/5 17:52
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MW_46_Permutations {
    public static void main(String[] args) {
        System.out.println(new Solution46().permute(new int[]{1, 2, 3}));
    }
}

class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, nums);
        return res;
    }

    /*回溯算法的一般公式
backtrack的公式：
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return

    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
* */
    // 函数中直接传递res，来代替公式中的result
    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            // 当没有创建新列表的时候res.add(list);运行结果[[], [], [], [], [], []]
            res.add(new ArrayList<>(list));
            return;
        }

        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
                backtrack(res, list, nums);
                // 将刚加进去的数取消
                list.remove(list.size() - 1);
            }
        }
    }
}