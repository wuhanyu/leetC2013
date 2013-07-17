import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_3
 * @problem Given a string, find the length of the longest substring without
 *          repeating characters. For example, the longest substring without
 *          repeating letters for "abcabcbb" is "abc", which the length is 3.
 *          For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hchzvfrkmlnozjk";
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
	}
	
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;	
    	int maxDis = 0;
    	HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
    	boolean hasStart = false;
    	int start = 0;
    	for (int i = 0; i < s.length(); i++){
    		int key = getKey(s.charAt(i));
    		if (!dict.containsKey(key)){
    			dict.put(key, i);
    		} else {
    			if (hasStart){
	    			maxDis = Math.max(maxDis, i - start - 1);
	    			start = Math.max(start, dict.get(key));
    			} else {
    				start = dict.get(key);
    				maxDis = i;
    				hasStart = true;
    			}
    			dict.put(key, i);
    		}
    	}
    	if (hasStart){
	    	dict = new HashMap<Integer, Integer>();
	    	for (int i = s.length() - 1; i >= 0; i--){
	    		int key = getKey(s.charAt(i));
	    		if (!dict.containsKey(key)){
	    			dict.put(key, i);
	    		} else {
	    			maxDis = Math.max(maxDis, s.length() - 1 - i);
	    			break;
	    		}
	    	}
    	} else {
    		maxDis = s.length();
    	}
    	return maxDis;
    }
    
    int getKey(char c){
    	return c - 'a';
    }

}
