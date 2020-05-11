package KuaiShou;

import java.util.Scanner;

/**
 * @Author AceDJH
 * @Date 2020/4/26 16:17
 * 大佬解析
 * https://www.nowcoder.com/discuss/417743?type=post&order=time&pos=&page=1&channel=
 */

// 可以使用两个数组来分别表示i对应的2i和2i + 1的权值
public class City {
    // 用来存奇数
    static int[] weight1 = new int[10000];
    // 用来存偶数
    static int[] weight2 = new int[10000];
    // 用来存输出
    static int[] out = new int[10000];
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int type = cin.nextInt();
            if (type == 1){
                int u = cin.nextInt();
                int v = cin.nextInt();
                int w = cin.nextInt();
                giveWeight(u, v, w);
            }else {
                int u = cin.nextInt();
                int v = cin.nextInt();
                out[sum++] = cost(u, v);
            }
        }

        for (int i = 0; i < sum; i++) {
            System.out.println(out[i]);
        }
    }

    public static void giveWeight(int i, int j, int weight){
        int big = Math.max(i, j);
        int small = Math.min(i, j);
        while (big != 1 && big != small){
            if (big % 2 == 0){
                big /= 2;
                weight2[big] += weight;
            }else {
                big /= 2;
                weight1[big] += weight;
            }
        }
        if (big != small){
            while (small != 1){
                if (small % 2 == 0){
                    small /= 2;
                    weight2[small] += weight;
                }else {
                    small /= 2;
                    weight1[small] += weight;
                }
            }
        }
    }

    public static int cost(int i, int j){
        int big = Math.max(i, j);
        int small = Math.min(i, j);
        int sum = 0;
        while (big != 1 && big != small){
            if (big % 2 == 0){
                big /= 2;
                sum += weight2[big];
            }else {
                big /= 2;
                sum += weight1[big];
            }
        }
        if (big != small){
            while (small != 1){
                if (small % 2 == 0){
                    small /= 2;
                    sum += weight2[small];
                }else {
                    small /= 2;
                    sum += weight1[small];
                }
            }
        }
        return sum;
    }
}


