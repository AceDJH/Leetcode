/**
 * @Author AceDJH
 * @Date 2020/9/23 22:30
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 */
public class Offer25 {
}

class Solution25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode header = null;
        if (l1.val <= l2.val){
            header = l1;
            l1 = l1.next;
        }else {
            header = l2;
            l2 = l2.next;
        }
        ListNode temp = header;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val){
                temp = temp.next = l1;
                l1 = l1.next;
            }else {
                temp = temp.next = l2;
                l2 = l2.next;
            }
        }
        temp.next = l1 != null ? l1 : l2;
        return header;
    }
}
