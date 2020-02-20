import java.util.Stack;

/**
 * @Author AceDJH
 * @Date 2020/2/20 17:11
 * 206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E_206_Reverse_Linked_List {
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*用栈
class Solution206 {
    public ListNode reverseList(ListNode head) {
        Stack<Integer> nums = new Stack<>();
        ListNode p = head;
        while(p != null){
            nums.push(p.val);
            p = p.next;
        }
        p = head;
        while (p != null){
            p.val = nums.pop();
            p = p.next;
        }
        return head;
    }
}*/

/*迭代
class Solution206 {
    public ListNode reverseList(ListNode head) {
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
}*/
/*递归解法，但是我并不能很好的理解，后面对递归理解更深后，回过头来再看
* */
class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}


