/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_44
 * @problem Implement wildcard pattern matching with support for '?' and '*'.
 * 
 *          '?' Matches any single character. '*' Matches any sequence of
 *          characters (including the empty sequence).
 * 
 *          The matching should cover the entire input string (not partial).
 * 
 *          The function prototype should be: bool isMatch(const char *s, const
 *          char *p)
 * 
 *          Some examples: isMatch("aa","a") ? false isMatch("aa","aa") ? true
 *          isMatch("aaa","aa") ? false isMatch("aa", "*") ? true isMatch("aa",
 *          "a*") ? true isMatch("ab", "?*") ? true isMatch("aab", "c*a*b") ?
 *          false
 */
public class WildcardMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new WildcardMatching().isMatch("aa", "aa"));
	}
	
    public boolean isMatch(String s, String p) {
        String[] strs = p.split("\\*");
        if (p.length() > 0 && strs.length == 0) return true;
        if (s.length() == 0 && p.length() == 0) return true;
        if (p.length() == 0) return false;
        if (p.charAt(0) != '*' && p.charAt(p.length() - 1) != '*' && strs.length == 1) {
            if (s.length() != p.length()) return false;
            return equalstr(0, s, p);
        }
        int si = 0;
        int i = 0;
        while (i < strs.length && si < s.length()){
            int index = getIndex(si, s, strs[i]);
            if (i == 0 && p.charAt(0) != '*' && index != 0) return false;
            if (index < 0) break;
            else {
                si = index + strs[i].length();
            }
            i++;
        }
        int lastPos  = s.length() - strs[strs.length - 1].length();
        if (lastPos >= 0 && p.charAt(p.length() - 1) != '*' && getIndex(lastPos, s, strs[strs.length - 1]) != lastPos) return false; 
        if (i == strs.length) return true;     
        return false;
    }
    
    int getIndex(int start, String s, String p){
        for (int i = start; i <= s.length() - p.length(); i++){
            if (equalstr(i, s, p)) return i;
        }
        return -1;
    }
    
    boolean equalstr(int start, String s, String p){
        if (s.length() - start < p.length()) return false;
        int j = 0;
        while (j < p.length() && (p.charAt(j) == '?' || s.charAt(start + j) == p.charAt(j))){
            j++;
        }
        if (j == p.length()) return true;   
        return false;
    }

}
