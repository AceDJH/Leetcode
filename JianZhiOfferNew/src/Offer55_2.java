/**
 * @Author AceDJH
 * @Date 2021/2/21 22:55
 */
public class Offer55_2 {
    public static void main(String[] args) {
        TreeNode tree = TreeTest.getTree();
        System.out.println(new Solution55_2Another().isBalanced(tree));
    }
}

class Solution55_2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left - right) <= 1){
            boolean balancedLeft = isBalanced(root.left);
            boolean balancedRight = isBalanced(root.right);
            return balancedLeft && balancedRight;
        }else {
            return false;
        }
    }

    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}

class Solution55_2Another {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        boolean balancedLeft = isBalanced(root.left);
        boolean balancedRight = isBalanced(root.right);
        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left - right) <= 1){
            return balancedLeft && balancedRight;
        }else {
            return false;
        }
    }

    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}