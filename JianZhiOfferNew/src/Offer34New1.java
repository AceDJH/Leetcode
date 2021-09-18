import java.util.ArrayList;
import java.util.List;

/**
 * @author AceDJH
 * @date 2021/9/12 3:20 下午
 */
public class Offer34New1 {
    class Solution {
        List<List<Integer>> lists = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            List<Integer> list = new ArrayList<>();
            path(root, list, target);
            return lists;
        }

        public void path(TreeNode node, List<Integer> list, int target){
            if (node == null){
                return;
            }
            target = target - node.val;
            list.add(node.val);
            if (target == 0 && node.right == null && node.left == null){
                lists.add(new ArrayList<>(list));
            }
            path(node.left, list, target);
            path(node.right, list, target);
            list.remove(list.size() - 1);
        }
    }
}
