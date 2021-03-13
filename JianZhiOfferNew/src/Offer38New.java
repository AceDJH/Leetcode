import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author AceDJH
 * @Date 2021/3/13 14:33
 */
public class Offer38New {
    public static void main(String[] args) {
        String[] strings = new Solution38New().permutation("aab");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}

class Solution38New {
    List<String> lists = new ArrayList<>();
    public String[] permutation(String s) {
        if(s == null || s.length() == 0){
            return new String[]{};
        }
        char[] chars = s.trim().toCharArray();
        getPermutation(chars, 0);
        return lists.toArray(new String[0]);
    }

    // 深度优先遍历，每次都是当前位置开始深度。
    public void getPermutation(char[] chars, int index){
        if (index == chars.length - 1){
            lists.add(String.valueOf(chars));
            return;
        }
        // 当前这个位置的set，保证 “每种字符只在此位固定一次” 
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++){
            if (set.contains(chars[i])){
                continue;
            }
            set.add(chars[i]);
            swap(chars, i, index);
            getPermutation(chars, index + 1);
            swap(chars, i, index);
        }
    }

    public void swap(char[] chars, int a, int b){
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
