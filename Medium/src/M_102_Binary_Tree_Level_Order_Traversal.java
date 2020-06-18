import java.util.*;

/**
 * @Author AceDJH
 * @Date 2020/6/18 9:13
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
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
 *   [9,20],
 *   [15,7]
 * ]
 */
public class M_102_Binary_Tree_Level_Order_Traversal {
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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> treeNodes =  new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()){
            int size = treeNodes.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = treeNodes.remove();
                list.add(curNode.val);
                if (curNode.left != null){
                    treeNodes.add(curNode.left);
                }
                if (curNode.right != null){
                    treeNodes.add(curNode.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
