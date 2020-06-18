import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author AceDJH
 * @Date 2020/6/18 11:32
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class E_107_Binary_Tree_Level_Order_Traversal_II {
}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        return reverseList(lists);
    }

    public static List<List<Integer>> reverseList(List<List<Integer>> lists){
        List<List<Integer>> newLists = new ArrayList<>();
        for (int i = lists.size(); i > 0; i--) {
            newLists.add(lists.get(i - 1));
        }
        return newLists;
    }
}
