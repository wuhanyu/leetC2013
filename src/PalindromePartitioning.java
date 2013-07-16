import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_131
 * @problem Given a string s, partition s such that every substring of the
 *          partition is a palindrome.
 * 
 *          Return all possible palindrome partitioning of s.
 * 
 *          For example, given s = "aab", Return
 * 
 *          [ ["aa","b"], ["a","a","b"] ]
 */
public class PalindromePartitioning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PalindromePartitioning().partition("abbcc"));
	}
	static ArrayList<ArrayList<String>> result;
	static boolean[][] isPali;
    public ArrayList<ArrayList<String>> partition(String s) {
        result = new ArrayList<ArrayList<String>>();
		int n = s.length();
		isPali = new boolean[n][n];
		traversal(0, n, s, new ArrayList<String>());
        return result;
    }
    
    void traversal(int start, int n, String s, ArrayList<String> list){
    	for (int i = start; i < n; i++){
    		if (isPalindrome(start, i, s)){
    			list.add(s.substring(start, i + 1));
    			if (i < n - 1){
    				traversal(i + 1, n, s, list);
    			} else {
    				result.add((ArrayList<String>) list.clone());
    			}
    			list.remove(list.size() - 1);
    		}
    	}
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
