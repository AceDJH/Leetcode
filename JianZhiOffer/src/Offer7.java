import java.util.HashMap;

/**
 * @Author AceDJH
 * @Date 2020/5/22 9:57
 * 面试题07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 */
public class Offer7 {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution7 {
    HashMap<Integer, Integer> dic = new HashMap<>();
    int[] pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    // 根通过前序找，左右子树通过中序找
    public TreeNode recur(int pre_root, int in_left, int in_right){
        if (in_left > in_right){
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[pre_root]);
        int index = dic.get(pre[pre_root]);
        treeNode.left = recur(pre_root + 1, in_left, index - 1);
        treeNode.right = recur(pre_root + index - in_left + 1, index + 1, in_right);
        return treeNode;
    }
}