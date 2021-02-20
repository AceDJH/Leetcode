import java.util.ArrayList;
import java.util.List;

/**
 * @Author AceDJH
 * @Date 2021/2/20 20:00
 */
public class Offer34 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        System.out.println(new Solution34().pathSum(root, 22));
    }
}

class Solution34 {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        pathSum(root, list, targetSum, 0);
        return lists;
    }

    public void pathSum(TreeNode root, List<Integer> list, int targetSum, int sum){
        if (root == null){
            return;
        }
        list.add(root.val);
        sum += root.val;
        if (sum == targetSum && (root.left == null && root.right == null)){
            lists.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        pathSum(root.left, list, targetSum, sum);
        pathSum(root.right, list, targetSum, sum);
        list.remove(list.size() - 1);
    }
}