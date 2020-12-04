package KuaiShou;

import java.util.Scanner;

/**
 * @Author AceDJH
 * @Date 2020/5/6 15:55
 * https://www.nowcoder.com/practice/247f7bd088764aefa7474cff27489095?tpId=98&tqId=32839&tPage=1&rp=1&ru=/ta/2019test&qru=/ta/2019test/question-ranking
 * 题目描述
 * 小明在越南旅游，参加了当地的娱乐活动。小明运气很好，拿到了大奖， 到了最后的拿奖金环节。小明发现桌子上放着一列红包，每个红包上写着奖金数额。
 * 现在主持人给要求小明在这一列红包之间“切”2刀，将这一列红包“切”成3组，并且第一组的奖金之和等于最后一组奖金和（允许任意一组的红包集合是空）。最终第一组红包的奖金之和就是小明能拿到的总奖金。小明想知道最多能拿到的奖金是多少，你能帮他算算吗。
 * <p>
 * 举例解释：桌子上放了红包  1, 2, 3, 4, 7, 10。小明在“4,7”之间、“7,10” 之间各切一刀，将红包分成3组 [1, 2, 3, 4]   [7]   [10]，其中第一组奖金之和=第三组奖金之和=10，所以小明可以拿到10越南盾。
 * 输入描述:
 * 第一行包含一个正整数n，(1<=n<= 200 000)，表示有多少个红包。
 * <p>
 * 第二行包含n个正整数d[i]，表示每个红包包含的奖金数额。其中1<= d[i] <= 1000 000 000
 * 输出描述:
 * 小明可以拿到的总奖金
 * 示例1
 * 输入
 * 复制
 * 5
 * 1 3 1 1 4
 * 输出
 * 复制
 * 5
 * 说明
 * [1,3,1]  [ ]   [1,4] ，其中第一组奖金和是5，等于第三组奖金和。所以小明可以拿到5越南盾
 * 示例2
 * 输入
 * 复制
 * 5
 * 1 3 2 1 4
 * 输出
 * 复制
 * 4
 * 说明
 * [1,3]   [2,1]  [4]，小明可以拿到4越南盾
 * 示例3
 * 输入
 * 复制
 * 3
 * 4 1 2
 * 输出
 * 复制
 * 0
 * 说明
 * [ ]  [4, 1, 2] [ ] ，小明没办法，为了保证第一组第三组相等，只能都分成空的。所以小明只能拿到0越南盾。
 */
public class JiangJin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int left = 0, right = n - 1;
        long left_sum = nums[left], right_sum = nums[right], max_sum = 0;
        while (left < right) {
            if (left_sum == right_sum) {
                max_sum = left_sum;
                left_sum += nums[++left];
                right_sum += nums[--right];
            } else if (left_sum > right_sum) {
                right_sum += nums[--right];
            } else {
                left_sum += nums[++left];
            }
        }
        System.out.println(max_sum);
    }
}
