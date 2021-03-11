/**
 * @Author AceDJH
 * @Date 2021/3/11 14:48
 */
public class Offer25New {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(3);
        ListNode r3 = new ListNode(4);
        r1.next = r2;
        r2.next = r3;
        System.out.println(new Solution25New().mergeTwoLists(l1, r1));
    }
}

class Solution25New {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode l1Remain = l1;
        ListNode l2Remain = l2;
        ListNode cur, head;
        if (l1.val <= l2.val){
            cur = l1;
            l1Remain = l1Remain.next;
        }else {
            cur = l2;
            l2Remain = l2Remain.next;
        }
        head = cur;
        while (l1Remain != null && l2Remain != null){
            if (l1Remain.val <= l2Remain.val){
                cur = cur.next = l1Remain;
                l1Remain = l1Remain.next;
            }else {
                cur.next = l2Remain;
                cur = cur.next;
                l2Remain = l2Remain.next;
            }
        }
        cur.next = l1Remain != null ? l1Remain : l2Remain;
        return head;
    }
}