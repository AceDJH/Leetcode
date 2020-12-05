/**
 * @Author AceDJH
 * @Date 2020/12/5 20:50
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 *
 *
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 *
 *
 *
 *
 *
 *
 *
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 *
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 *
 *
 *
 *
 *
 *
 *
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 *
 *
 */
public class Offer36 {
    public static void main(String[] args) {
        Solution36.Node node5 = new Solution36.Node(5);
        Solution36.Node node1 = new Solution36.Node(1);
        Solution36.Node node3 = new Solution36.Node(3);
        Solution36.Node node2 = new Solution36.Node(2, node1, node3);
        Solution36.Node node4 = new Solution36.Node(4, node2, node5);
        System.out.println(new Solution36().treeToDoublyList(node4));
    }
}

class Solution36 {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    Node list = null;
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        Node cur = root;
        Node head = null;
        while (cur.left != null){
            cur = cur.left;
        }
        // 取得最小节点
        head = cur;
        cur = root;
        Node tail = null;
        while (cur.right != null){
            cur = cur.right;
        }
        // 取得最大点
        tail = cur;
        convertNode(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    public void convertNode(Node node){
        if (node == null){
            return;
        }
        if (node.left != null){
            convertNode(node.left);
        }
        if (list != null){
            list.right = node;
        }
        node.left = list;
        list = node;
        if (node.right != null){
            convertNode(node.right);
        }
    }
}
