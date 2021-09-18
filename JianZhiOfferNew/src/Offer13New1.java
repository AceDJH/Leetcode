import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author AceDJH
 * @date 2021/9/11 2:30 下午
 */
public class Offer13New1 {
    public static void main(String[] args) {
        System.out.println(new Offer13New1().new Solution().movingCount(3, 2, 17));
    }
    class Solution {
        int m;
        int n;
        public int movingCount(int m, int n, int k) {
            this.m = m;
            this.n = n;
            Queue<Integer> queue = new LinkedList<>();
            int count = 0;
            boolean[][] isVisited = new boolean[m][n];
            queue.add(0);
            queue.add(0);
            isVisited[0][0] = true;
            int[][] dis = new int[][]{
                    {-1, 0},
                    {0, -1},
                    {0, 1},
                    {1, 0},
            };
            while (!queue.isEmpty()){
                int row = queue.poll();
                int line = queue.poll();
                count++;
                for (int[] di : dis) {
                    if (canReach(row + di[0], line + di[1], k)
                            && !isVisited[row + di[0]][line + di[1]]){
                        queue.add(row + di[0]);
                        queue.add(line + di[1]);
                        isVisited[row + di[0]][line + di[1]] = true;
                    }
                }
            }
            return count;
        }

        public boolean canReach(int i, int j, int k){
            if (i >= 0 && i < m && j >= 0 && j < n){
                return numSum(i) + numSum(j) <= k;
            }
            return false;
        }

        public int numSum(int num){
            int sum = 0;
            while (num != 0){
                sum += num % 10;
                num /= 10;
            }
            return sum;
        }
    }
}
