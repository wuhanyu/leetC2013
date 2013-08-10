import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_30
 * @problem You are given a string, S, and a list of words, L, that are all of
 *          the same length. Find all starting indices of substring(s) in S that
 *          is a concatenation of each word in L exactly once and without any
 *          intervening characters.
 * 
 *          For example, given: S: "barfoothefoobarman" L: ["foo", "bar"]
 * 
 *          You should return the indices: [0,9]. (order does not matter).
 */
public class SubstringwithConcatenationofAllWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String S = "barfoothefoobarman";
		String[] L = {"foo","bar"};
		System.out.println(new SubstringwithConcatenationofAllWords().findSubstring(S, L));
	}
	
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (L.length == 0) return result;
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++){
            if (dict.containsKey(L[i])){
                dict.put(L[i], dict.get(L[i]) + 1);
            } else {
                dict.put(L[i], 1);
            }
        }
        int length = L[0].length();
        for (int i = 0; i <= S.length() - length * L.length; i++) {
            HashMap<String, Integer> has = (HashMap<String, Integer>) dict.clone();
            int j = 0;
            while (j < L.length){
                String key = S.substring(i + j * length, i + j * length + length);
                if (has.containsKey(key)){
                    if (has.get(key) > 0){
                        has.put(key, has.get(key) - 1);
                        j++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (j == L.length) result.add(i);
        }
        return result;
    }

}
