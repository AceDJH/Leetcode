/**
 * @Author AceDJH
 * @Date 2021/3/11 14:34
 */
public class Offer22New {
}

class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        while (cur != null && k > 0){
            cur = cur.next;
            --k;
        }
        while (cur != null){
            cur = cur.next;
            head = head.next;
        }
        return head;
    }
}