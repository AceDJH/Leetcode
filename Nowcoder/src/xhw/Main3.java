package xhw;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author AceDJH
 * @date 2021/8/25 8:41 下午
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] nums = new int[n][1];
        for (int i = 0; i < n; i++) {
            String line = s.nextLine();

        }
        System.out.println(useTime(null));
    }

    public static int useTime(int[][] nums){
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i][0] == -1){
                map.put(i, nums[i][1]);
            }else {
                deque.offerLast(i);
            }
        }
        while (!deque.isEmpty()){
            if (map.containsKey(nums[deque.peekFirst()][0])){
                int i = deque.pollFirst();
                map.put(i, map.get(nums[i][0]) + nums[i][1]);
            }else {
                deque.offerLast(deque.pollFirst());
            }
        }
        Collection<Integer> values = map.values();
        int sum = 0;
        for (Integer value : values) {
            sum = Math.max(sum, value);
        }
        return sum;
    }
}
