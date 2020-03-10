/**
 * @Author AceDJH
 * @Date 2020/3/8 22:54
 * 用来转换Leetcode的名字，方便起名
 */
import java.util.Scanner;
public class convertLeetcodeMediumName{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入题目名,当前为Medium类：");
        String name = sc.nextLine();
        StringBuilder stringBuilder = new StringBuilder(name);
        int index = stringBuilder.indexOf(".");
        stringBuilder.deleteCharAt(index);
        String str2 = stringBuilder.toString().replace(' ', '_');
        // 更改名字中的难度时，修改degree
        String degree = "M_";
        System.out.println(degree + str2);
    }
}
