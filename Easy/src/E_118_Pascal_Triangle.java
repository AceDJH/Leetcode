import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/2/26 22:18
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E_118_Pascal_Triangle {
    public static void main(String[] args) {
        System.out.println(new Solution118().generate(5).toString());
    }
}

class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        // 为了在逻辑上更契合，因此行和列都从1开始
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i)
                    list.add(1);
                else {
                    // 由于此处牵扯的是索引，list的索引从0开始
                    int num = lists.get(i - 2).get(j - 2) + lists.get(i - 2).get(j - 1);
                    list.add(num);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
