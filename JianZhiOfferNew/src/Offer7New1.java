import java.util.HashMap;
import java.util.Map;

/**
 * @author AceDJH
 * @date 2021/9/10 5:48 下午
 */
public class Offer7New1 {
    class Solution {
        Map<Integer, Integer> in = new HashMap<>();
        int[] preorder;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            for (int i = 0; i < inorder.length; i++) {
                in.put(inorder[i], i);
            }
            return tree(0, 0, inorder.length - 1);
        }

        public TreeNode tree(int pre, int start, int end){
            if (start > end){
                return null;
            }
            int mid = in.get(preorder[pre]);
            TreeNode root = new TreeNode(preorder[pre]);
            root.left = tree(pre + 1, start, mid - 1);
            root.right = tree(pre + mid - start + 1, mid + 1, end);
            return root;
        }
    }
}
