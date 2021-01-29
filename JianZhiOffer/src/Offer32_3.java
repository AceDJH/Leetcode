import java.util.*;

/**
 * @Author AceDJH
 * @Date 2021/1/29 11:47
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
 *   [20,9],
 *   [15,7]
 * ]
 */
public class Offer32_3 {
    public static void main(String[] args) {
        TreeNode tree = TreeTest.getTree();
        System.out.println(new Solution32_3().levelOrder(tree));
    }
}

class Solution32_3 {
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
        boolean isRight = true;
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
                /*此处可使用工具类简化
                if (isRight){
                    List<Integer> list2 = new ArrayList<>();
                    for (int i = list.size() - 1; i >= 0; i--) {
                        list2.add(list.get(i));
                    }
                    lists.add(list2);
                }else {
                    lists.add(list);
                }*/
                if (isRight){
                    Collections.reverse(list);
                }
                lists.add(list);
                isRight = !isRight;
            }
        }
        return lists;
    }
}
