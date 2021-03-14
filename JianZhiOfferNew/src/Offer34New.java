import java.util.ArrayList;
import java.util.List;

/**
 * @Author AceDJH
 * @Date 2021/3/14 20:43
 */
public class Offer34New {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null){
            return new ArrayList<>();
        }
        dfs(root, target, new ArrayList<>());
        return res;
    }

    public void dfs(TreeNode node, int remain, List<Integer> list){
        if (node == null){
            return;
        }
        int temp = remain - node.val;
        list.add(node.val);
        if (temp == 0 && node.left == null && node.right == null){
            res.add(new ArrayList<>(list));
        }
        dfs(node.left, temp, list);
        dfs(node.right, temp, list);
        list.remove(list.size() - 1);
    }
}
