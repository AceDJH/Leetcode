package KuaiShou;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 在你面前有n个蓄水池，他们组成了树形结构（由n-1条边连接）。蓄水池节点编号从1开始到n。对每个蓄水池节点来说，他的儿子蓄水池节点都摆放在他的下面，并且和它用水管相连，根据重力，水会向下流动。现在我们要在蓄水池上做一些操作：
 * 1. 把节点v填满水。然后v的所有儿子节点水也会被填满
 * 2. 清空节点v的水。然后v所有的父亲节点水都会被清空
 * 3. 询问每个蓄水池节点是否有水。
 * 初始状态时候，每个节点都是空的。
 * 现在我们会依次进行一系列操作，我们想提前知道每次操作后的结果，你能帮忙解决吗？
 * //思路：先创建HashSet数组建图，创建full数组表示当前节点是否有水，在根据条件进行充水或者清水
 * /*
 * 小数是大数的父结点
 * 5
 * 1 2
 * 5 1
 * 2 3
 * 4 2
 * 树：
 * 1
 * | \
 * 2 5
 * |\
 * 3 4
 *  */
public class Pool {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int num;
        while (cin.hasNextInt()){
            num = cin.nextInt();
            HashSet<Integer>[] tree = new HashSet[num+1];
            boolean[] flag = new boolean[num+1];

            for (int i = 0; i < num+1; i++) {
                tree[i] = new HashSet<>();
            }
            for (int i = 0; i < num-1; i++) {
                int a = cin.nextInt();
                int b = cin.nextInt();
                tree[a].add(b);
                tree[b].add(a);
            }

            int caozuo_num = cin.nextInt();

            for (int i = 0; i < caozuo_num; i++) {
                int c = cin.nextInt();
                int d = cin.nextInt();
                switch (c){
                    case 1:
                        floor(d,tree,flag);
                        break;
                    case 2:
                        clear(d,tree,flag);
                        break;
                    case 3:
                        System.out.println(flag[d]==true?1:0);
                        break;
                }
            }

        }
    }

    private static void clear(int d, HashSet<Integer>[] tree, boolean[] flag) {
        flag[d]= false;
        for (Integer integer : tree[d]) {
            if(integer<d){
                clear(integer,tree,flag);
            }
        }
    }

    private static void floor(int d, HashSet<Integer>[] tree, boolean[] flag) {
        flag[d] = true;
        for (Integer integer : tree[d]) {
            if(integer>d){
                floor(integer,tree,flag);
            }
        }
    }
}
