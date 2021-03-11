/**
 * @Author AceDJH
 * @Date 2021/3/11 14:43
 */
public class Offer24New {
}

class Solution24New {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
