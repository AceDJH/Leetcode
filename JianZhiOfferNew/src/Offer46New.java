/**
 * @Author AceDJH
 * @Date 2021/3/15 14:33
 */
public class Offer46New {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < chars.length; i++) {
            int temp = Integer.parseInt(s.substring(i - 1, i + 1));
            if (temp >= 10 && temp <= 25){
                if (i > 1){
                    dp[i] = dp[i - 1] + dp[i - 2];
                }else {
                    dp[i] = 2;
                }
            }else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }
}


