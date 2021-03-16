

/**
 * @Author AceDJH
 * @Date 2021/3/16 10:44
 */
public class Offer50New {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0){
            return ' ';
        }
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++){
            nums[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++){
            if (nums[s.charAt(i) - 'a'] == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
