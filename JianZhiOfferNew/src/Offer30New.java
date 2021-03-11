import java.util.Stack;

/**
 * @Author AceDJH
 * @Date 2021/3/11 16:41
 */
public class Offer30New {
}

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty()){
            min.push(x);
        }else {
            if (x < min.peek()){
                min.push(x);
            }else {
                min.push(min.peek());
            }
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}