import java.util.Stack;

/**
 * @Author AceDJH
 * @Date 2021/3/9 15:15
 */
public class Offer8 {
}

class CQueue1 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public CQueue1() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack2.push(value);
    }

    public int deleteHead() {
        if (!stack1.isEmpty()){
            return stack1.pop();
        }
        if (!stack2.isEmpty()){
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return stack1.pop();
        }
        return -1;
    }
}
