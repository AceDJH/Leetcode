import java.util.HashMap;
import java.util.Map;

/**
 * @Author AceDJH
 * @Date 2021/2/7 20:33
 */
public class Offer7 {
}

class Solution7 {
    Map<Integer, Integer> inorderIndex = new HashMap<>();
    int[] pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    public TreeNode recur(int preNode, int left, int right){
        if (left > right){
            return null;
        }
        TreeNode node = new TreeNode(pre[preNode]);
        int inIndex = inorderIndex.get(pre[preNode]);
        /*在pre中的下标，
        若当前节点下标为preNode，
        则左子树头为preNode + 1，
        右子树为preNode + 左子树长度 + 1，
        左子树长度为在inorder中的当前节点的下标 - 左方尽头（left）*/
        node.left = recur(preNode + 1, left,inIndex - 1);
        node.right = recur(preNode + inIndex - left + 1, inIndex + 1, right);
        return node;
    }
}