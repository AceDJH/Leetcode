/**
 * @Author AceDJH
 * @Date 2021/3/10 10:48
 * https://www.nowcoder.com/practice/da785ea0f64b442488c125b441a4ba4a?tpId=117&tab=answerKey
 */
public class BinaryTreeMaximumPathSum {
    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum (TreeNode root) {
        // write code here
        if (root == null){
            return 0;
        }
        getMaxSum(root);
        return maxSum;
    }

    public int getMaxSum(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = getMaxSum(node.left);
        int right = getMaxSum(node.right);
        int sum = node.val;
        if (left > 0){
            sum += left;
        }
        if (right > 0){
            sum += right;
        }
        maxSum = Math.max(sum, maxSum);
        return Math.max(left, right) > 0 ? Math.max(left, right) + node.val : node.val;
    }
}
