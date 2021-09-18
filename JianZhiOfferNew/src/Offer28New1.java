import java.util.ArrayList;
import java.util.List;

/**
 * @author AceDJH
 * @date 2021/9/12 9:06 上午
 */
// 这种做法过不了
// [1,2,2,2,null,2]这种用例
public class Offer28New1 {
    public static void main(String[] args) {
        TreeNode root = TreeTest1.getTree();
        System.out.println(new Offer28New1().new Solution().isSymmetric(root));
    }
    class Solution {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        public boolean isSymmetric(TreeNode root) {
            if(root == null){
                return false;
            }
            lnrOrder(root);
            rnlOrder(root);
            for(int i = 0; i < a.size(); i++){
                if(!a.get(i).equals(b.get(i))){
                    return false;
                }
            }
            return true;
        }

        public void lnrOrder(TreeNode node){
            if(node == null){
                a.add(0);
                return;
            }
            lnrOrder(node.left);
            a.add(node.val);
            lnrOrder(node.right);
        }

        public void rnlOrder(TreeNode node){
            if(node == null){
                b.add(0);
                return;
            }
            rnlOrder(node.right);
            b.add(node.val);
            rnlOrder(node.left);
        }
    }
}
