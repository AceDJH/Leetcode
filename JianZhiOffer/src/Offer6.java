import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author AceDJH
 * @Date 2020/5/14 21:46
 * 面试题06. 从尾到头打印链表
 */
public class Offer6 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        System.out.println(new Solution6().reversePrint(listNode1).length);
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
/*class Solution6 {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        int[] listNodes = new int[stack.size()];
        for (int i = 0; stack.size() != 0; i++) {
            listNodes[i] = stack.pop().val;
        }
        return listNodes;
    }
}*/

class Solution6 {
    ArrayList<Integer> values = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] listNodes = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            listNodes[i] = values.get(i);
        }
        return listNodes;
    }

    public void recur(ListNode head){
        if (head != null){
            if (head.next != null){
                recur(head.next);
            }
            values.add(head.val);
        }
    }
}