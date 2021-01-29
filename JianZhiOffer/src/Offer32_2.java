import java.util.*;

/**
 * @Author AceDJH
 * @Date 2021/1/29 11:05
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class Offer32_2 {
    public static void main(String[] args) {
        TreeNode tree = TreeTest.getTree();
        System.out.println(new Solution32_2().levelOrder(tree));
    }
}

class Solution32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new LinkedList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list;
        list = new ArrayList<>();
        list.add(root.val);
        lists.add(list);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null && node.left != null) {
                    queue.add(node.left);
                    list.add(node.left.val);
                }
                if (node != null && node.right != null) {
                    queue.add(node.right);
                    list.add(node.right.val);
                }
            }
            if (!list.isEmpty()){
                lists.add(list);
            }
        }
        return lists;
    }
}
