package xhw;

/**
 * @author AceDJH
 * @date 2021/9/1 8:42 下午
 */
public class Test {
    public static void main(String[] args) {
        String a = "apple instanceOf fruit";
        String[] instanceOVES = a.split("instanceOf");
//        for (String instanceOF : instanceOVES) {
//            System.out.println(instanceOF + "_");
//        }
        String key = instanceOVES[1].trim();
        String value = instanceOVES[0].trim();
        System.out.println(key + value);
    }
}
