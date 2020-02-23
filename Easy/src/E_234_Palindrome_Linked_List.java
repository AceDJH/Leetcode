import java.util.List;
import java.util.Stack;

/**
 * @Author AceDJH
 * @Date 2020/2/23 17:16
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E_234_Palindrome_Linked_List {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(2);
        ListNode a4 = new ListNode(1);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        System.out.println(new Solution234().isPalindrome(a1));
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int num = stack.size(); //此处需要注意保存栈大小，若是在for中直接用size，会一直改变，导致for提前结束
        for (int i = 0; i < num / 2; i++) {
            if (p.val != stack.pop())
                return false;
            p = p.next;
        }
        return true;
    }
}

/*官方题解中有一个将一个链表分成两半的方法：
快慢指针，慢指针一次走一步，快指针一次走两步
但由于代码有点复杂，因此了解部分思想就好
* */