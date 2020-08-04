import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MatchGenerator;

/**
 * @Author AceDJH
 * @Date 2020/5/24 22:48
 * 剑指Offer P82
 */
public class SortAgesP82 {
    public static void main(String[] args) {
        int num = 10;
        int[] ages = new int[num];
        for (int i = 0; i < num; i++) {
            ages[i] = (int) (Math.random() * 99);
            System.out.print(ages[i] + "  ");
        }
        SortAges(ages);
        System.out.println("------------------");
        for (int i = 0; i < num; i++) {
            System.out.print(ages[i] + "  ");
        }
    }

    public static void SortAges(int ages[]) {
        if (ages.length <= 0) {
            return;
        }
        final int oldestAge = 99;
        int[] timesOfAge = new int[oldestAge + 1];
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            if (age < 0 || age > oldestAge) {
                return;
            }
            ++timesOfAge[age];
        }

        //index表示新的ages数组的下标
        int index = 0;
        // i用来表示当前年龄
        for (int i = 0; i < oldestAge; i++) {
            // timesOfAge[i]表示i年龄有多少个人
            for (int j = 0; j < timesOfAge[i]; j++) {
                // 将年龄从小到大的放进数组里
                ages[index] = i;
                ++index;
            }
        }
    }
}
