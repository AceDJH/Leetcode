/**
 * @Author AceDJH
 * @Date 2021/3/12 10:54
 */
public class Offer36New {
}

class Solution36New {
    class Node {
        public int val;
        public Solution36New.Node left;
        public Solution36New.Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Solution36New.Node _left, Solution36New.Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    Node pre, cur, head;
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        inOrder(root);
        head.left = cur;
        cur.right = head;
        return head;
    }

    public void inOrder(Node node){
        if (node != null){
            inOrder(node.left);
            cur = node;
            if (pre != null) {
                pre.right = cur;
                cur.left = pre;
            }else {
                head = cur;
            }
            pre = cur;
            inOrder(node.right);
        }
    }
}