/**
 * @Author AceDJH
 * @Date 2021/3/11 15:18
 */
public class Offer26New {
}

class Solution26New {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null){
            return false;
        }
        return sub(A, B);
    }

    public boolean sub(TreeNode A, TreeNode B){
        boolean result = false;
        if (A != null && B != null){
            if (A.val == B.val){
                result = isSub(A, B);
            }
            if (!result){
                result = sub(A.left, B);
            }
            if (!result){
                result = sub(A.right, B);
            }
        }
        return result;
    }

    public boolean isSub(TreeNode A, TreeNode B) {
        if (B == null){
            return true;
        }
        if (A == null || A.val != B.val){
            return false;
        }
        return isSub(A.left, B.left) && isSub(A.right, B.right);
    }
}
