import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author AceDJH
 * @Date 2021/2/27 14:00
 */
public class M_144_Binary_Tree_Preorder_Traversal {
    public static void main(String[] args) {
        TreeNode node = TreeTest.getTree();
        System.out.println(new Solution144().preorderTraversal(node));
    }
}

// 递归解法
/*class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        preorderTraversal(root, lists);
        return lists;
    }

    public void preorderTraversal(TreeNode root, List<Integer> lists) {
        if (root != null){
            lists.add(root.val);
            preorderTraversal(root.left, lists);
            preorderTraversal(root.right, lists);
        }
    }
}*/

// 非递归解法,自己写的
/*class Solution144 {
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> lists = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null){
            stack.push(root);
            lists.add(root.val);
        }
        TreeNode node = root;
        while (!stack.isEmpty()){
            while (node.left != null){
                stack.push(node.left);
                lists.add(node.left.val);
                node = node.left;
            }
            while (!stack.isEmpty() && stack.peek().right == null){
                stack.pop();
                if (stack.isEmpty()){
                    return lists;
                }
            }
            node = stack.pop();
            if (node.right != null){
                stack.push(node.right);
                lists.add(node.right.val);
                node = node.right;
            }
        }
        return lists;
    }
}*/

class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> lists = new ArrayList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null){
            while (node != null){
                stack.push(node);
                lists.add(node.val);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return lists;
    }
}