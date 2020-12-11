import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/12/11 21:35
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class Offer38 {
}

class Solution38 {
    List<String> list = new ArrayList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return list.toArray(new String[s.length()]);
    }

    public void dfs(int x){
        if (c.length - 1 == x){
            list.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])){
                continue;
            }
            set.add(c[i]);
            swap(c, i, x);
            dfs(x + 1);
            swap(c, i, x);
        }
    }

    public void swap(char[] chars, int a, int b){
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}