import java.util.ArrayList;
import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/12/27 9:06
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 */
public class Offer54 {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        node3.left = node1;
        node3.right = node4;
        node1.right = node2;
        System.out.println(new Solution54Better().kthLargest(node3, 1));

    }
}

class Solution54 {
    List<Integer> list = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        getList(root);
        int index = list.size() - k;
        return list.get(index);
    }
    public void getList(TreeNode root){
        if (root != null){
            getList(root.left);
            list.add(root.val);
            getList(root.right);
        }
    }
}

class Solution54Better {
    int res, kth;
    public int kthLargest(TreeNode root, int k) {
        kth = k;
        getList(root);
        return res;
    }
    public void getList(TreeNode root){
        if (root != null){
            getList(root.right);
            if (--kth == 0){
                res = root.val;
                return;
            }
            getList(root.left);
        }
    }
}
