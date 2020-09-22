/**
 * @Author AceDJH
 * @Date 2020/9/22 23:17
 */
public class Offer23 {
    public static void main(String[] args) {
        System.out.println("lala");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode head = node1;
        node6.next = node3;
        System.out.println(new Solution23().findInsertNode(head).val);
    }
}

class Solution23 {
    public ListNode findInsertNode(ListNode head){
        if (head == null || head.next == null){
            return null;
        }
        int nodesInLoop = 1;
        ListNode meetNode = meetingNode(head);
        ListNode meetNodeTemp = meetNode;
        while (meetNodeTemp.next != meetNode) {
            meetNodeTemp = meetNodeTemp.next;
            nodesInLoop++;
        }
        ListNode pNode1 = head;
        for (int i = 0; i < nodesInLoop; i++) {
            pNode1 = pNode1.next;
        }
        ListNode pNode2 = head;
        while (pNode1 != pNode2) {
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode1;
    }

    public ListNode meetingNode(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && slow != null) {
            if (slow == fast){
                return fast;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }
}