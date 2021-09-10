package leetcode.editor.cn;
//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 👍 991 👎 0

import java.util.Arrays;

//Java：最小路径和
public class T64_MinimumPathSum{
    public static void main(String[] args) {
        Solution solution = new T64_MinimumPathSum().new Solution();
        // TO TEST
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        };
        System.out.println(solution.minPathSum(grid));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0){
            return -1;
        }
        int rows = grid.length;
        int lines = grid[0].length;
        int[][] dp = new int[rows + 1][lines + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, 201);
        }
        dp[1][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= lines; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i - 1][j - 1];
            }
        }
        return dp[rows][lines];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
