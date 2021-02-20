import java.util.Stack;

/**
 * @Author AceDJH
 * @Date 2021/2/20 18:10
 */
public class Offer31 {
}

class Solution31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0){
            return true;
        }
        if (pushed.length == 0 || popped.length == 0){
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0,  j = 0;
        while (i < pushed.length){
            if (stack.isEmpty() || stack.peek() != popped[j]){
                stack.push(pushed[i++]);
            }
            while (!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}