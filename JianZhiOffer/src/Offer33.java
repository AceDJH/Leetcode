/**
 * @Author AceDJH
 * @Date 2020/11/17 22:38
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 */
public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0){
            return true;
        }
        return isPost(postorder, 0, postorder.length - 1);
    }

    public boolean isPost(int[] postorder, int start, int end){
        if (postorder == null || end < 0 || start < 0){
            return false;
        }
        if (start >= end){
            return true;
        }
        int root = postorder[end];
        int i = start;
        for (; i < end; i++) {
            if (postorder[i] > root){
                break;
            }
        }
        int j = i;
        for (; j < end; j++){
            if (postorder[j] < root){
                return false;
            }
        }
        boolean left = true;
        if (i > 0){
            left = isPost(postorder, start, i - 1);
        }
        boolean right = true;
        if (i <= end){
            right = isPost(postorder, i, end - 1);
        }
        return left && right;
    }
}
