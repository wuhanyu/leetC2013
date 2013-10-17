public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        if (s == null) return new ArrayList<String>();
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
        if (!dp[s.length()]) return new ArrayList<String>();
        
        ArrayList<ArrayList<String>> wordlists = new ArrayList<ArrayList<String>>();
        for (int i = 0; i <= s.length(); i++) wordlists.add(new ArrayList<String>());
        for (int i = 0; i < s.length(); i++){
            ArrayList<String> words = wordlists.get(i);
            if (words.size() > 0 || i == 0) {
                for (String word : dict) {
                    if (s.length() - i >= word.length() && 
                    s.substring(i, i + word.length()).equals(word)) {
                        ArrayList<String> twords = wordlists.get(i + word.length());
                        if (i == 0) twords.add(word);
                        else {
                            for (int j = 0; j < words.size(); j++){
                                twords.add(words.get(j) + " " + word);
                            }
                        }
                    }
                }
            }
        }
        
        return wordlists.get(s.length());
    }
}
