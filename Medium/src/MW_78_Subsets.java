import java.util.ArrayList;
import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/4/4 22:00
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class MW_78_Subsets {
    public static void main(String[] args) {
        System.out.println(new Solution78().subsets(new int[]{1, 2, 3}));
        String a = "123";
        System.out.println(a.substring(1));
        int nthBit = 1 << 3;
        System.out.println(nthBit);
    }
}

class Solution78 {
    /*public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subSets = new ArrayList<>();
        // 添加一个空集
        subSets.add(new ArrayList<>());
        for (int num : nums) {
            // 创建新的集合列表
            List<List<Integer>> newSubSets = new ArrayList<>();
            // 给原来已经添加进去的子集都添加进去新的数字
            for (List<Integer> subSet : subSets) {
                List<Integer> newSubSet = new ArrayList<>();
                newSubSet.addAll(subSet);
                newSubSet.add(num);
                newSubSets.add(newSubSet);
            }
            // 将刚生成的子集填入总体子集中
            for (List<Integer> newSubSet : newSubSets) {
                subSets.add(newSubSet);
            }
        }
        return subSets;
    }*/

    //方法三：字典排序（二进制排序） 子集,位运算作用是真的多
    // 函数的所有注释我都以输入为{1，2，3}为例来写
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subSets = new ArrayList<>();
        int n = nums.length;// 3
        // 为了在生成掩码时，能够生成000，而非0，所要做的准备，1<<3 => 1000
        int nthBit1 = 1 << n;
        // 2的3次方为8，共有8种掩码
        for (int i = 0; i < Math.pow(2, n); i++) {
            // 比如i为0，则0 | 1000 => 1000，然后截取掉首位，000，生成所需掩码
            String bitmask = Integer.toBinaryString(i | nthBit1).substring(1);
            List<Integer> newSubSet = new ArrayList<>();
            for (int index = 0; index < n; index++) {
                // 相当于是将nums和掩码做与运算
                if (bitmask.charAt(index) == '1'){
                    newSubSet.add(nums[index]);
                }
            }
            subSets.add(newSubSet);
        }
        return subSets;
    }
}
