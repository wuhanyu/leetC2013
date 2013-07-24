public class DecodeWays {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int num = s.charAt(0) - '0';
        num = num * 10 + s.charAt(1) - '0';
        if (num == 0) return 0;
        else if (num <= 26 && num % 10 != 0) {
            dp[1] = 2;
        } else if (num > 26 && num % 10 == 0){
            return 0;
        } else {
            dp[1] = 1;
        }
        
        for (int i = 2; i < s.length(); i++){
            num = s.charAt(i-1) - '0';
            num = num * 10 + s.charAt(i) - '0';
            if (num == 0) return 0;
            else if (num > 26 && num % 10 == 0) return 0;
            else if (num > 26) dp[i] = dp[i-1];
            else if (num <= 26 && num > 10 && num != 20) dp[i] = dp[i-1] + dp[i-2];
            else dp[i] = dp[i-2];
        }
        return dp[s.length() - 1];
    }
}
