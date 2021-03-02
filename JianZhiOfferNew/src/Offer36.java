import java.util.Stack;

/**
 * @Author AceDJH
 * @Date 2021/3/2 10:14
 */
public class Offer36 {
    public static void main(String[] args) {
        System.out.println(new Solution36().treeToDoublyList(null));
    }
}

class Solution36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
// 非递归
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        Node pre = null, head = null;
        Node cur = root;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null){
                pre.right = cur;
            }else {
                head = cur;
            }
            cur.left = pre;
            pre = cur;
            cur = cur.right;
        }
        head.left = pre;
        pre.right = head;
        return head;
    }

    // 递归
/*    Node head, pre;
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    public void dfs(Node cur){
        if (cur == null){
            return;
        }
        dfs(cur.left);
        if (pre != null){
            pre.right = cur;
        }else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }*/
}