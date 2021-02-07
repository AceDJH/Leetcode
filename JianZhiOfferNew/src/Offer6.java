import java.util.Stack;

/**
 * @Author AceDJH
 * @Date 2021/2/7 20:15
 */
public class Offer6 {
}

class Solution6 {
    public int[] reversePrint(ListNode head) {
        if (head == null){
            return new int[]{};
        }
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] nums = new int[stack.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = stack.pop();
        }
        return nums;
    }
}