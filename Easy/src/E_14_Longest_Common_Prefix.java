/**
 * @Author AceDJH
 * @Date 2020/2/21 17:39
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E_14_Longest_Common_Prefix {
    public static void main(String[] args) {
        String[] a = {"flower", "flow", "flight"};
        String[] b = {"caa", "", "a", "acb"};
        String[] c = {"b", "cb", "cab"};
        String[] d = {"b"};
        System.out.println("aasdasdas".indexOf("flower"));
        System.out.println(new Solution14().longestCommonPrefix(a));
    }
}

/*通过巨多的if语句写了出来，但是毫无疑问，丝毫不优雅，必须改进
class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1){
            return strs[0];
        }
        int prefix = 0;
        for (int i = 0; i < strs.length - 1; i++) {
            if (strs[i].length() == 0)
                return "";
            int num = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (j >= strs[i + 1].length())
                    break;
                if (strs[i].charAt(j) == strs[i + 1].charAt(j))
                    num++;
                else
                    break;
            }
            if (num == 0)
                return "";
            if (prefix == 0)
                prefix = num;
            else if (num < prefix)
                prefix = num;
        }
        if (prefix == 0)
            return "";
        return strs[0].substring(0, prefix);
    }
}*/

/*水平扫描法
public int indexOf(String str)
返回指定子字符串第一次出现的字符串内的索引。
返回的索引是其中的最小值k ：

 this.startsWith(str, k)

如果k的值不存在，则返回-1 。
参数
str - 要搜索的子字符串。
结果
指定的子串，或第一次出现的索引 -1如果不存在这样的发生。
* 因此算法中的while每执行一次,就会从prefix去掉最后一位
*通过这种方法，prefix会越来越小
*
class Solution14{
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}*/

class Solution14{
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}


