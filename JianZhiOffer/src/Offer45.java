/**
 * @Author AceDJH
 * @Date 2020/12/19 9:52
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 *
 * 提示:
 *
 * 0 < nums.length <= 100
 * 说明:
 *
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 */
public class Offer45 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(new Solution45().minNumber(nums));
    }
}

class Solution45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public void quickSort(String[] strs, int start, int end){
        if (start < end){
            int pivot = partition(strs, start, end);
            quickSort(strs, start, pivot - 1);
            quickSort(strs, pivot + 1, end);
        }
    }

    public int partition(String[] strs, int start, int end){
        String temp = strs[start];
        while (start < end){
            while (start < end && ((strs[end] + temp).compareTo(temp + strs[end])) >= 0){
                end--;
            }
            strs[start] = strs[end];
            while (start < end && ((strs[start] + temp).compareTo(temp + strs[start])) <= 0){
                start++;
            }
            strs[end] = strs[start];
        }
        strs[start] = temp;
        return start;
    }
}
