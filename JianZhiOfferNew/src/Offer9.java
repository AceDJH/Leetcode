import java.util.Stack;

/**
 * @Author AceDJH
 * @Date 2021/2/9 10:19
 */
public class Offer9 {
}

class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack2.push(value);
    }

    public int deleteHead() {
        if (!stack1.isEmpty()){
            return stack1.pop();
        }else if (!stack2.isEmpty()){
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return stack1.pop();
        }else {
            return -1;
        }
    }
}