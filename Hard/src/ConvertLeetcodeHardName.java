import java.util.Scanner;

/**
 * @Author AceDJH
 * @Date 2020/5/25 17:02
 */
public class ConvertLeetcodeHardName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入题目名,当前为Hard类：");
        String name = sc.nextLine();
        StringBuilder stringBuilder = new StringBuilder(name);
        int index = stringBuilder.indexOf(".");
        stringBuilder.deleteCharAt(index);
        String str2 = stringBuilder.toString().replace(' ', '_');
        // 更改名字中的难度时，修改degree
        String degree = "H_";
        System.out.println(degree + str2);
    }
}
