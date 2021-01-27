/**
 * @Author AceDJH
 * @Date 2021/1/27 11:05
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 */
public class Offer68_1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.left = node7;
        node4.right = node8;
        System.out.println(new Solution68_1().lowestCommonAncestor(root, node7, node8).val);
    }
}

class Solution68_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        TreeNode small;
        TreeNode big;
        if (p.val <= q.val){
            small = p;
            big = q;
        }else {
            small = q;
            big = p;
        }
        TreeNode node = new TreeNode(0);
        order(root, small, big, node);
        return node;
    }

    public void order(TreeNode treeNode, TreeNode small, TreeNode big, TreeNode node){
        if(treeNode == null){
            return;
        }
        if (treeNode.val >= small.val && treeNode.val <= big.val){
            node.val = treeNode.val;
        }else if (treeNode.val >= big.val){
            order(treeNode.left, small, big, node);
        }else {
            order(treeNode.right, small, big, node);
        }
    }
}
class Solution68_1Better1{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        // 保证p.val < q.val
        if (p.val > q.val){
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        while (root != null){
            if (root.val < p.val){
                root = root.right;
            }else if (root.val > q.val){
                root = root.left;
            }else {
                break;
            }
        }
        return root;
    }
}

class Solution68_1Better2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else {
            return root;
        }
    }
}