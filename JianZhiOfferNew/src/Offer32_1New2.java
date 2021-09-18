import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author AceDJH
 * @date 2021/9/12 11:40 上午
 */
public class Offer32_1New2 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<List<Integer>> lists = new ArrayList<>();
            while (!queue.isEmpty()){
                List<Integer> list = new ArrayList<>();
                for(int i = queue.size(); i > 0; i--){
                    TreeNode poll = queue.poll();
                    list.add(poll.val);
                    if (poll.left != null){
                        queue.offer(poll.left);
                    }
                    if (poll.right != null){
                        queue.offer(poll.right);
                    }
                }
                lists.add(list);
            }
            return lists;
        }
    }
}
