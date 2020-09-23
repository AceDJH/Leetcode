/**
 * @Author AceDJH
 * @Date 2020/9/23 22:08
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 */
public class Offer24 {
}

class Solution24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode current = head;
        ListNode reversedHead = null;
        while (current != null) {
            ListNode next = current.next;
            if (next == null){
                reversedHead = current;
            }
            current.next = pre;
            pre = current;
            current = next;
        }
        return reversedHead;
    }
}
