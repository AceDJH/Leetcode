package xhw;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author AceDJH
 * @date 2021/9/1 8:42 下午
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){

            TreeSet<Integer> set=new TreeSet<Integer>();
            int n=sc.nextInt();
            if(n>0){
                for(int i=0;i<n;i++){
                    set.add(sc.nextInt());
                }
            }
            for(Integer i:set){
                System.out.println(i);
            }
        }
        System.out.println(5);
    }
}
