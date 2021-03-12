/**
 * @Author AceDJH
 * @Date 2021/3/12 10:28
 */
public class Offer35New {
}

class Solution35New {
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        Node cur = head;
        while (cur != null){
            insertNode(cur);
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null){
            if (cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node newHead = head.next;
        while (cur != null){
            Node temp = cur.next;
            cur.next = cur.next.next;
            if (cur.next != null){
                temp.next = cur.next.next;
            }else {
                temp.next = null;
            }
            cur = cur.next;
        }
        return newHead;
    }

    public void insertNode(Node node){
        Node temp = new Node(node.val);
        temp.next = node.next;
        node.next = temp;
    }
}

