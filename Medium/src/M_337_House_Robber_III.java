

/**
 * @Author AceDJH
 * @Date 2021/3/14 15:08
 */
/*public class M_337_House_Robber_III {
    public static void main(String[] args) {
        System.out.println(new M_337_House_Robber_III().rob(new TreeNode()));
    }
    Map<TreeNode, Integer> select = new HashMap<>();
    Map<TreeNode, Integer> unSelect = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }
        select.put(null, 0);
        unSelect.put(null, 0);
        getCount(root);
        return Math.max(select.get(root), unSelect.get(root));
    }

    public void getCount(TreeNode node){
        if (node == null){
            return;
        }
        getCount(node.left);
        getCount(node.right);
        int a = node.val + unSelect.get(node.left) + unSelect.get(node.right);
        select.put(node, a);
        int b = Math.max(select.get(node.left), unSelect.get(node.left));
        int c = Math.max(select.get(node.right), unSelect.get(node.right));
        unSelect.put(node, b + c);
    }
}*/

public class M_337_House_Robber_III {
    public static void main(String[] args) {
        System.out.println(new M_337_House_Robber_III().rob(new TreeNode()));
    }
    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }
        int[] res = getCount(root);
        return Math.max(res[0], res[1]);
    }

    public int[] getCount(TreeNode node){
        if (node == null){
            return new int[]{0, 0};
        }
        int[] left = getCount(node.left);
        int[] right = getCount(node.right);

        int[] dp = new int[2];

        // dp[0]：以当前 node 为根结点的子树能够偷取的最大价值，规定 node 结点不偷
        // dp[1]：以当前 node 为根结点的子树能够偷取的最大价值，规定 node 结点偷
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = node.val + left[0] + right[0];
        return dp;
    }
}
