/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_5
 * @problem Given a string S, find the longest palindromic substring in S. You
 *          may assume that the maximum length of S is 1000, and there exists
 *          one unique longest palindromic substring.
 */
public class LongestPalindromicSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcac";
		System.out.println(new LongestPalindromicSubstring().longestPalindrome(s));
	}
	
	static boolean[][] isPali;
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int maxi = 0;
    	int maxj = 0;
    	int maxlen = 0;
    	isPali = new boolean[s.length()][s.length()];
    	for (int i = 0; i < s.length(); i++){
    		for (int j = i; j >= 0; j--){
    			if (isPalindrome(j, i, s) && (i - j + 1 > maxlen)){
    				maxlen = i - j + 1;
    				maxj = j;
    				maxi = i;
    			}
    		}
    	}
    	
    	return s.substring(maxj, maxi + 1);
        
    }
    
    boolean isPalindrome(int i, int j, String s){
    	if (isPali[i][j]) return true;
    	if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPali[i+1][j-1])){
    		isPali[i][j] = true;
    		return true;
    	}
    	return false;
    }

}
