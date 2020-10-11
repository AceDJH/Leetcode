/**
 * @Author AceDJH
 * @Date 2020/9/27 23:12
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 */
public class Offer26 {
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
class Solution26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return isSub(A, B);
    }

    public boolean isSub(TreeNode A, TreeNode B){
        boolean result = false;
        if (A != null && B != null) {
            if (A.val == B.val){
                result = isTreeAHasTreeB(A, B);
            }
            if (!result){
                result = isSub(A.left, B);
            }
            if (!result){
                result = isSub(A.right, B);
            }
        }
        return result;
    }

    public boolean isTreeAHasTreeB(TreeNode A, TreeNode B){
        if (B == null){
            return true;
        }
        if (A == null || A.val != B.val){
            return false;
        }
        return isTreeAHasTreeB(A.left, B.left) && isTreeAHasTreeB(A.right, B.right);
    }

}

