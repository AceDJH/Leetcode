import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author AceDJH
 * @Date 2020/4/13 20:18
 * 1046. 最后一块石头的重量
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E_1046_Last_Stone_Weight {
    public static void main(String[] args) {
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println(new Solution1046().lastStoneWeight(stones));
    }
}

class Solution1046 {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        // 在真正的开发中应克隆原数组，以防破坏原数组
        // int[] newStones = stones.clone();
        // 由于数组自排序为从小到大，若是想要从大到小比较麻烦，因此选后面的数
        int n = stones.length - 1;
        for (int i = 0; i < stones.length; i++) {
            Arrays.sort(stones);
            if (stones[n - 1] == 0) {
                return stones[n];
            }
            if (stones[n] == stones[n - 1]) {
                stones[n] = 0;
            } else {
                stones[n] = stones[n] - stones[n - 1];
            }
            stones[n - 1] = 0;
        }
        return stones[n];
    }
}
