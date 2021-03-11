import java.util.Stack;

/**
 * @Author AceDJH
 * @Date 2021/3/11 16:57
 */
public class Offer31New {
}

class Solution31New {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < pushed.length){
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
            i++;
        }
        return stack.isEmpty();
    }
}