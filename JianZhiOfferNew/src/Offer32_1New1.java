import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.ToIntFunction;

/**
 * @author AceDJH
 * @date 2021/9/12 11:40 上午
 */
public class Offer32_1New1 {
    class Solution {
        public int[] levelOrder(TreeNode root) {
            if (root == null){
                return new int[]{};
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            return list.stream().mapToInt(value -> value).toArray();
        }
    }
}
