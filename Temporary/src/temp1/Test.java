package temp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author AceDJH
 * @Date 2020/11/19 13:44
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(Math.abs(new Random().nextInt() % 100));
            System.out.println(list.get(i));
        }
        list.stream().forEach(num -> { int a = num + 3; int b = num + 5; System.out.println(num + 100);
        });
        int a = 3;
    }
}
