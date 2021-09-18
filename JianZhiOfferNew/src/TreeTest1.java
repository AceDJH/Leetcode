/**
 * @Author AceDJH
 * @Date 2021/1/29 11:30
 *
 *          1
 *         / \
 *        2   2
 *       / \ / \
 *      3  4 4  3
 */
public class TreeTest1 {
    public static TreeNode getTree(){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        return root;
    }
}
