/**
 * @Author AceDJH
 * @Date 2021/3/11 16:02
 */
public class Offer28New {
}

class Solution28New {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode a, TreeNode b) {
        if (a == null && b == null){
            return true;
        }
        if (a == null || b == null){
            return false;
        }
        if (a.val != b.val){
            return false;
        }
        return isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }
}


