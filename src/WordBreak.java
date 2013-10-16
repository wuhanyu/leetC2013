public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null) return true;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++){
            if (dp[i]) {
                for (String word : dict) {
                    if (s.length() - i >= word.length() && 
                    s.substring(i, i + word.length()).equals(word)) dp[i + word.length()] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
