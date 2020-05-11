package KuaiShou;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 现在你的班级刚刚参加了一个只有单选题的考试。班级一共n个学生，考试有m个问题。每个题目都有5个可选答案（A，B，C，D，E）。并且每个题目只有一个正确答案。每个题目的分数并不一样，第i个题目的分数用a[i]表示。如果题目没答对该题会获得0分。
 * 考试结束后，每个学生都记得自己的答案，但是他们还不知道正确答案是什么。如果非常乐观的考虑，他们班级最多可能得到多少分呢？
 */
public class Score {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n,m;
        while (cin.hasNext()){
            n = cin.nextInt();
            m = cin.nextInt();
            //System.out.println(String.format("%d %d",n,m));
            char[][] s = new char[n][m];
            for (int i = 0; i < n; i++) {
                s[i]=new char[m];
                s[i]=cin.next().toCharArray();
            }

            int[] a=new int[m];
            for (int i = 0; i < m; i++) {
                a[i]=cin.nextInt();
            }

            int maxtol = 0;

            for (int i = 0; i < m; i++) {
                HashMap<Character,Integer> map = new HashMap<Character, Integer>();
                int max = 1;
                for (int j = 0; j < n; j++) {
                    if(map.containsKey(s[j][i])){
                        max=Math.max(max,map.get(s[j][i])+1);
                        map.put(s[j][i],map.get(s[j][i])+1);
                    }else {
                        map.put(s[j][i],1);
                    }
                }
                maxtol += max*a[i];
            }

            System.out.println(maxtol);






//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.print(s[i][j]);
//                }
//                System.out.println();
//            }
//            for (int i = 0; i < m; i++) {
//                System.out.print(a[i]);
//            }

        }
    }
}
