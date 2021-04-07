/**
 * @Author AceDJH
 * @Date 2021/4/6 23:31
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class M_2_Add_Two_Numbers {
    public static void main(String[] args) {
        ListNode l1Node1 = new ListNode(2);
        ListNode l1Node2 = new ListNode(4);
        ListNode l1Node3 = new ListNode(3);
        ListNode l2Node1 = new ListNode(5);
        ListNode l2Node2 = new ListNode(6);
        ListNode l2Node3 = new ListNode(4);
        l1Node1.next = l1Node2;
        l1Node2.next = l1Node3;
        l2Node1.next = l2Node2;
        l2Node2.next = l2Node3;
        System.out.println(new M_2_Add_Two_Numbers().addTwoNumbers(l1Node1, l2Node1).val);
        // System.out.println(9999999991L + 9);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int pre = 0;
        ListNode head = new ListNode();
        ListNode cur = head;
        while (l1 != null || l2 != null){
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + pre;
            if (sum >= 10){
                pre = 1;
                sum %= 10;
            }else {
                pre = 0;
            }
            ListNode node = new ListNode(sum);
            cur.next = node;
            cur = node;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (pre == 1){
            cur.next = new ListNode(1);
        }
        return head.next;
    }
}


