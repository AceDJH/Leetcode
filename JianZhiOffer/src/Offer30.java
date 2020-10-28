import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author AceDJH
 * @Date 2020/10/28 20:58
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 */
public class Offer30 {
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || x < min.peek()){
            min.push(x);
        }else {
            min.push(min.peek());
        }
    }

    public void pop() {
        if (!stack.isEmpty()){
            stack.pop();
            min.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()){
            return stack.peek();
        }
        return 0;
    }

    public int min() {
        if (!stack.isEmpty()){
            return min.peek();
        }
        return 0;
    }
}


