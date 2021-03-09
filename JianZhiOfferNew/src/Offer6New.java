import java.util.Stack;

/**
 * @Author AceDJH
 * @Date 2021/3/9 14:48
 */
public class Offer6New {
}

class Solution6New {
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
        for(int i = 0; i < nums.length; i++){
            nums[i] = stack.pop();
        }
        return nums;
    }
}