public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < dp.length; i++){
            if (s.charAt(i) == ')'){
                if (dp[i-1] == 0){
                    if (s.charAt(i-1) == '('){
                        if (i > 2) dp[i] = dp[i-2] + 2;
                        else dp[i] = 2;
                    }
                } else {
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                        if (i - dp[i - 1] - 2 >= 0) dp[i] = dp[i-1] + 2 + dp[i - dp[i - 1] - 2];
                        else dp[i] = dp[i-1] + 2;
                    } 
                }
            }
        }
        int max = 0;
        for (int i = 1; i < dp.length; i++){
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}
