package GenShuiXue;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/11/13 18:43
 * 整形数组中滑动窗口的最大值
 * 给定一个整形数组arr，和一个size，输出在每一个size长度的子数组内的最大值
 * 示例：
 * 输入：[2, 3, 4, 2, 6, 2, 5, 1]  3
 * 输出：[4, 4, 6, 6, 6, 5]
 * 解释：以每3个元素为一组，比如第一组[2, 3, 4]，输出最大值4，第二组[3, 4, 2]输出最大值4，以此类推。
 */
public class WindowMax {
    public static void main(String[] args) {

    }
    public List maxInWindows(int[] arr, int size) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length - size; i++){
            int temp = arr[i];
            for(int j = 0; j < size; j++){
                if(arr[i + j] > temp){
                    temp = arr[i + j];
                }
            }
            list.add(temp);
        }
        return list;
    }
    // 还有一种时间复杂度为O（n）的解法
    // 使用队列，每次读入一个数，与其中的数字进行对比，有些太小的就不必存，淘汰其中的数可以使用下标
}
