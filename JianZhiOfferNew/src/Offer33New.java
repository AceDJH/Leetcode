/**
 * @Author AceDJH
 * @Date 2021/3/11 21:25
 */
public class Offer33New {
}

class Solution33New {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0){
            return true;
        }
        return isPost(postorder, 0, postorder.length - 1);
    }

    public boolean isPost(int[] postorder, int start, int end){
        if (start <= end){
            int left = start;
            while (postorder[left] < postorder[end]){
                left++;
            }
            int right = left;
            while (postorder[right] > postorder[end]){
                right++;
            }
            if (right != end){
                return false;
            }
            return isPost(postorder, start, left - 1) && isPost(postorder, left, right - 1);
        }
        return true;
    }
}
