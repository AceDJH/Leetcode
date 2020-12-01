import java.util.ArrayList;
import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/12/1 22:47
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class Offer34 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        System.out.println(new Solution34().pathSum(root, 22));
    }
}

class Solution34 {
    private List<List<Integer>> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List list = new ArrayList<Integer>();
        findPath(root, sum, list);
        return path;
    }

    void findPath(TreeNode node, int sum, List<Integer> list){
        if (node == null){
            return;
        }
        sum = sum - node.val;
        list.add(node.val);
        if (sum == 0 && node.left == null && node.right == null){
            path.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        findPath(node.left, sum, list);
        findPath(node.right, sum, list);
        list.remove(list.size() - 1);
    }
}



