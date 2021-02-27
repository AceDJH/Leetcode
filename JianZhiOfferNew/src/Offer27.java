/**
 * @Author AceDJH
 * @Date 2021/2/27 13:45
 */
public class Offer27 {

}

class Solution27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}