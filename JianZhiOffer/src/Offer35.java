

/**
 * @Author AceDJH
 * @Date 2020/12/4 21:53
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 *
 *
 *
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 *
 *
 *
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 */
public class Offer35 {
    public static void main(String[] args) {
    }
}
/*使用hash
class Solution35 {
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        Node pre = new Node(head.val);
        Node cloneHead = pre;
        Node node = head.next;
        HashMap<Node, Node> map = new HashMap<>(16);
        map.put(head, cloneHead);
        while (node != null){
            Node cloneNode = new Node(node.val);
            map.put(node, cloneNode);
            pre.next = cloneNode;
            pre = cloneNode;
            node = node.next;
        }
        Node temp = head;
        Node cloneTemp = cloneHead;
        while (temp != null){
            cloneTemp.random = map.get(temp.random);
            cloneTemp = cloneTemp.next;
            temp = temp.next;
        }
        return cloneHead;
    }
}*/

// 使用拆链表的方法
class Solution35 {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        // 增加复制节点
        Node cur = head;
        while (cur != null){
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
        // 连接random
        cur = head;
        while (cur != null){
            if (cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 抽取链表
        cur = head;
        Node cloneHead = head.next;
        Node cloneNode = head.next;
        while (cloneNode != null){
            cur.next = cloneNode.next;
            cur = cur.next;
            if (cloneNode.next != null){
                cloneNode.next = cloneNode.next.next;
            }
            cloneNode = cloneNode.next;
        }
        return cloneHead;
    }
}

