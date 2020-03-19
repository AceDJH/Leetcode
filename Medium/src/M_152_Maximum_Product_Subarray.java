import java.util.ArrayList;

/**
 * @Author AceDJH
 * @Date 2020/3/19 15:10
 * 152. 乘积最大子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class M_152_Maximum_Product_Subarray {
    public static void main(String[] args) {
        int[] nums = new int[]{0};
        System.out.println(new Solution152().maxProduct(nums));
    }
}

/*自己的做法是：
由于乘0后，结果会变为0，因此通过0将数组划分，计算每一块的最大值，然后比较最大值
class Solution152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
        ArrayList<Integer> numsList = new ArrayList<Integer>();
        int negative = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
        }
        int curEven = Integer.MIN_VALUE;
        int curOdd = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                numsList.add(nums[i]);
                if (nums[i] < 0)
                    negative++;
            }else {
                if (negative % 2 == 0){
                    curEven = Math.max(max, oddNegative(numsList));
                }else {
                    curOdd = Math.max(max, evenNegative(numsList));
                }

                int tempMax = Math.max(curEven, curOdd);
                if (tempMax > max)
                    max = tempMax;
                negative = 0;
                numsList.clear();
            }
        }

        if (negative % 2 == 0) {
            curEven = Math.max(max, oddNegative(numsList));
        } else {
            curOdd = Math.max(max, evenNegative(numsList));
        }

        int tempMax = Math.max(curEven, curOdd);
        if (tempMax > max)
            max = tempMax;

        return max;
    }

    public int oddNegative(ArrayList<Integer> list){
        if (list.size() == 0)
            return 0;
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            max *= list.get(i);
        }
        return max;
    }
    //其实偶数个负数可以合并到奇数个负数这个函数里面，不过之前已经写好了，而且偶数毕竟执行快，就不合并了
    public int evenNegative(ArrayList<Integer> list){
        if (list.size() == 0)
            return 0;
        int max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                temp = temp * list.get(j);
                if (temp > max)
                    max = temp;
            }
        }
        return max;
    }
}*/

/*解题区一个大佬，做法有好几处可以借鉴的地方，很强，这个人
* */
class Solution152 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        // 这一步就很机智，专门写两个数初始设为1，和max不关联， 就不用单独判断首位了
        int imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            // 当出现负数时，最小的会变成最大的，最大的会变成最小的，这个结论直接让算法精简了无数
            if (nums[i] < 0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
}
