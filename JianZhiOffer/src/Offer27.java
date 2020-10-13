/**
 * @Author AceDJH
 * @Date 2020/10/13 20:33
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 */
public class Offer27 {
}

class Solution27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        if (root.right == null && root.left == null){
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null){
            mirrorTree(root.left);
        }
        if (root.right != null){
            mirrorTree(root.right);
        }
        return root;
    }
}
