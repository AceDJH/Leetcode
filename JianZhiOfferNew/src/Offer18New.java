/**
 * @Author AceDJH
 * @Date 2021/3/10 16:32
 */
public class Offer18New {
}

class Solution18New {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode headReal = head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            if (cur.val == val){
                if (pre != null){
                    pre.next = cur.next;
                }else {
                    headReal = head.next;
                    return headReal;
                }

            }
            pre = cur;
            cur = cur.next;
        }
        return headReal;
    }
}
