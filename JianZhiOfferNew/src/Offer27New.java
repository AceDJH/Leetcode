/**
 * @Author AceDJH
 * @Date 2021/3/11 15:54
 */
public class Offer27New {
}

class Solution27New {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        node.left = mirrorTree(root.right);
        node.right = mirrorTree(root.left);
        return node;
    }
}