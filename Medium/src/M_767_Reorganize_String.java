import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author AceDJH
 * @Date 2021/3/2 16:04
 * 767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 */
public class M_767_Reorganize_String {
}

class Solution767 {
    public String reorganizeString(String S) {
        if (S == null || S.length() == 0){
            return "";
        }
        int max = 0;
        int[] counts = new int[26];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            max = Math.max(max, counts[c - 'a']);
        }
        int limit = (S.length() + 1) / 2;
        if (max > limit){
            return "";
        }
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return counts[o2 - 'a'] - counts[o1 - 'a'];
            }
        });
        for (char i = 'a'; i <= 'z'; i++){
            if (counts[i - 'a'] > 0){
                queue.offer(i);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (queue.size() > 1){
            Character poll1 = queue.poll();
            Character poll2 = queue.poll();
            stringBuilder.append(poll1).append(poll2);
            int index1 = poll1 - 'a';
            int index2 = poll2 - 'a';
            counts[index1]--;
            counts[index2]--;
            if (counts[index1] > 0){
                queue.offer(poll1);
            }
            if (counts[index2] > 0){
                queue.offer(poll2);
            }
        }
        if (queue.size() > 0){
            stringBuilder.append(queue.poll());
        }
        return stringBuilder.toString();
    }
}