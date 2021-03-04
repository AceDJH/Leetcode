import java.util.*;
/**
 * @Author AceDJH
 * @Date 2021/3/4 12:13
 * 链接：https://ac.nowcoder.com/acm/problem/16422
 * 来源：牛客网
 *
 * 题目描述
 * 图书馆中每本书都有一个图书编码，可以用于快速检索图书，这个图书编码是一个正整数。
 *
 * 每位借书的读者手中有一个需求码，这个需求码也是一个正整数。如果一本书的图书编码恰好以读者的需求码结尾，那么这本书就是这位读者所需要的。
 *
 * 小 D 刚刚当上图书馆的管理员，她知道图书馆里所有书的图书编码，她请你帮她写一个程序，对于每一位读者，求出他所需要的书中图书编码最小的那本书，如果没有他需要的书，请输出-1。
 *
 * 输入描述:
 * 输入的第一行，包含两个正整数 n 和 q，以一个空格分开，分别代表图书馆里书的数量和读者的数量。
 * 接下来的 n 行，每行包含一个正整数，代表图书馆里某本书的图书编码。
 * 接下来的 q 行，每行包含两个正整数，以一个空格分开，第一个正整数代表图书馆里读者的需求码的长度，第二个正整数代表读者的需求码。
 * 输出描述:
 * 输出有 q 行，每行包含一个整数，如果存在第 i 个读者所需要的书，则在第 i 行输出第 i 个读者所需要的书中图书编码最小的那本书的图书编码，否则输出-1。
 * 示例1
 * 输入
 * 复制
 * 5 5
 * 2123
 * 1123
 * 23
 * 24
 * 24
 * 2 23
 * 3 123
 * 3 124
 * 2 12
 * 2 12
 * 输出
 * 复制
 * 23
 * 1123
 * -1
 * -1
 * -1
 * 说明
 * 第一位读者需要的书有 2123、1123、23，其中 23 是最小的图书编码。
 * 第二位读者需要的书有 2123、1123，其中 1123 是最小的图书编码。
 * 对于第三位，第四位和第五位读者，没有书的图书编码以他们的需求码结尾，即没有他们需要的书，输出-1。
 * 备注:
 * 对于 20%的数据，1 ≤ n ≤ 2。  另有 20%的数据，q= 1。
 * 另有 20%的数据，所有读者的需求码的长度均为1。
 * 另有 20%的数据，所有的图书编码按从小到大的顺序给出。
 * 对于 100%的数据，1≤n ≤1,000，1 ≤ q ≤ 1,000，所有的图书编码和需求码均不超过 10,000,000。
 *
 */
public class Librarian {
    public static void main(String[] args){
        int n, q, length, num;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = sc.nextInt();
        int[] book = new int[n];
        for(int i = 0; i < n; i++){
            book[i] = sc.nextInt();
        }
        Arrays.sort(book);
        int[] d = new int[8];
        d[0] = 1;
        d[1] = 10;
        for(int i = 1; i < n; i++){
            d[i + 1] = d[i] * 10;
        }
        boolean flag = false;
        // int j;
        for(int i = 0; i < q; i++){
            length = sc.nextInt();
            num = sc.nextInt();
/*            for(j=0;j<n;j++)
            {
                if(book[j]%Math.pow(10,length)==num)
                {
                    System.out.println(book[j]);
                    break;
                }
            }
            if(j==n) {
                System.out.println(-1);
            }*/
            for(int j = 0; j < n; j++){
                flag = false;
                if(book[j] % d[length] == num){
                    System.out.println(book[j]);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println(-1);
            }
        }
    }
}
