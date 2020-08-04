import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/4/5 22:31
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M_39_Combination_Sum {
    public static void main(String[] args) {
        System.out.println(new Solution39().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}

class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // 排序为后面做服务
        Arrays.sort(candidates);
        backtrack(res, list, 0, candidates, target);
        return res;
    }

    // 加start的原因是为了去重，这样生成的结果就不会有[2,2,3], [3,2,2]都出现的情况
    public void backtrack(List<List<Integer>> res, List<Integer> list, int start, int[] candidates, int target) {
        if (listSum(list) == target) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (listSum(list) + candidates[i] <= target) {
                list.add(candidates[i]);
                backtrack(res, list, i, candidates, target);
                list.remove(list.size() - 1);
            }
        }
    }

    public int listSum(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
