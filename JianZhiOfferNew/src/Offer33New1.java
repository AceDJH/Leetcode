/**
 * @author AceDJH
 * @date 2021/9/12 12:24 下午
 */
public class Offer33New1 {
    public static void main(String[] args) {
        System.out.println(new Offer33New1().new Solution().verifyPostorder(new int[]{1,2,5,10,6,9,4,3}));
    }
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            if (postorder == null || postorder.length == 0){
                return false;
            }
            return isPost(postorder, 0, postorder.length - 1);
        }
        
        public boolean isPost(int[] postorder, int left, int n){
            if (left >= n){
                return true;
            }
            int mid = postorder[n];
            int right = left;
            for (int i = left; i < n; i++) {
                if (postorder[i] > mid){
                    break;
                }
                right++;
            }
            for(int i = right; i < n; i++){
                if (postorder[i] < mid){
                    return false;
                }
            }
            return isPost(postorder, left, right - 1) && isPost(postorder, right, n - 1);

        }
    }
}
