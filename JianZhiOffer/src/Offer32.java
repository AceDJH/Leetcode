import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author AceDJH
 * @Date 2020/11/2 21:25
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 */
public class Offer32 {
    class Solution32 {
        public int[] levelOrder(TreeNode root) {
            if (root == null){
                return new int[0];
            }
            Queue<TreeNode> queue = new LinkedList<>();
            // 此处可以先使用list，最后创建一个与size一样大的数组
            int[] result = new int[2000];
            int i = 0;
            queue.add(root);
            while (!queue.isEmpty()){
                TreeNode temp = queue.poll();
                result[i++] = temp.val;
                if (temp.left != null){
                    queue.add(temp.left);
                }
                if (temp.right != null){
                    queue.add(temp.right);
                }
            }
            return Arrays.copyOfRange(result, 0, i);
        }
    }
}
