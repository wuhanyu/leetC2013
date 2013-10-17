public class WordBreakII {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        if (s == null) return result;
        
        ArrayList<ArrayList<Integer>> wordlists = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= s.length(); i++) wordlists.add(new ArrayList<Integer>());
        for (int i = 0; i < s.length(); i++){
            ArrayList<Integer> words = wordlists.get(i);
            if (words.size() > 0 || i == 0) {
                for (String word : dict) {
                    if (s.length() - i >= word.length() && 
                    s.substring(i, i + word.length()).equals(word)) {
                        wordlists.get(i + word.length()).add(i);
                    }
                }
            }
        }
        
        if (wordlists.get(s.length()).size() == 0) return result;
        else {
            result = getResult(wordlists, s.length(), s);
        }
        
        return result;
    }
    
    public ArrayList<String> getResult(ArrayList<ArrayList<Integer>> wordlists, int index, String s) {
        ArrayList<Integer> words = wordlists.get(index);
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i) == 0) result.add(s.substring(0, index));
            else {
                ArrayList<String> pre = getResult(wordlists, words.get(i), s);
                String word = s.substring(words.get(i), index);
                for (int j = 0; j < pre.size(); j++) result.add(pre.get(j) + " " + word);
            }
        }
        return result;
    }
}
