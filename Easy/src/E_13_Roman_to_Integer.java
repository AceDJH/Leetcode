/**
 * @Author AceDJH
 * @Date 2020/2/28 20:53
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E_13_Roman_to_Integer {
    public static void main(String[] args) {
        System.out.println(new Solution13().romanToInt("MCMXCIV"));
    }
}

/*自己的做法，有点长，但是当罗马数字输入错误时依然可以跑
解题区有一个人的switch写的不错，在下面展示出来
class Solution13 {
    public int romanToInt(String s) {
        if (s.length() == 0)
            return 0;
        int i = 0;
        int sum = 0;
        while(i < s.length()){
            int lastIndex = s.length() - 1;
            switch (s.charAt(i)){
                case 'I':
                    if (i != lastIndex){
                        if (s.charAt(i + 1) == 'V'){
                            sum += 3;
                            i ++;
                        }else if (s.charAt(i + 1) == 'X'){
                            sum += 8;
                            i ++;
                        }
                    }
                    sum += 1;
                    i++;
                    break;
                case 'X':
                    if (i != lastIndex){
                        if (s.charAt(i + 1) == 'L'){
                            sum += 30;
                            i ++;
                        }else if (s.charAt(i + 1) == 'C'){
                            sum += 80;
                            i ++;
                        }
                    }
                    sum += 10;
                    i++;
                    break;
                case 'C':
                    if (i != lastIndex){
                        if (s.charAt(i + 1) == 'D'){
                            sum += 300;
                            i ++;
                        }else if (s.charAt(i + 1) == 'M'){
                            sum += 800;
                            i ++;
                        }
                    }
                    sum += 100;
                    i++;
                    break;
                case 'V':
                    sum += 5;
                    i++;
                    break;
                case 'L':
                    sum += 50;
                    i++;
                    break;
                case 'D':
                    sum += 500;
                    i++;
                    break;
                case 'M':
                    sum += 1000;
                    i++;
                    break;
                default:
                    return 0;
            }
        }
        return sum;
    }
}*/
/*需要保证罗马数字输入一定为正确的，即前数小于后数的情况只有这六种*/
class Solution13 {
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
