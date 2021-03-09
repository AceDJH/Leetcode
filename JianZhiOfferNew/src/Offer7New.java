import java.util.HashMap;

/**
 * @Author AceDJH
 * @Date 2021/3/9 14:53
 */
public class Offer7New {
}

class Solution7New {
    HashMap<Integer, Integer> inIndex = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || inorder.length == 0 || preorder.length != inorder.length){
            return null;
        }
        for (int i = 0; i < inorder.length; i++){
            inIndex.put(inorder[i], i);
        }
        return createTree(preorder, inorder, 0, 0, preorder.length - 1);
    }

    public TreeNode createTree(int[] preorder, int[] inorder, int pre, int start, int end){
        if (start <= end){
            int mid = inIndex.get(preorder[pre]);
            TreeNode node = new TreeNode(preorder[pre]);
            node.left = createTree(preorder, inorder, pre + 1, start, mid - 1);
            node.right = createTree(preorder, inorder, pre + mid - start + 1, mid + 1, end);
            return node;
        }
        return null;
    }
}
