import java.util.Arrays;

/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_115
 * @problem Given a string S and a string T, count the number of distinct
 *          subsequences of T in S.
 * 
 *          A subsequence of a string is a new string which is formed from the
 *          original string by deleting some (can be none) of the characters
 *          without disturbing the relative positions of the remaining
 *          characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is
 *          not).
 * 
 *          Here is an example: S = "rabbbit", T = "rabbit"
 * 
 *          Return 3.
 */
public class DistinctSubsequences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "CBAZTAAABBCTA";
		String T = "CAT";
		System.out.println(new DistinctSubsequences().numDistinct(S, T));

	}
	
    public int numDistinct(String S, String T) {
    	if (S.length() == 0 || T.length() == 0) return 0;
        int m = T.length();
        int n = S.length();
        int[][] dp = new int[n][m];
        int base, val;
        val = 0;
        for (int i = n - 1; i >= 0; i--){
        	base = 1;
        	if (T.charAt(m-1) == S.charAt(i)){
        		val += base;
        	}
        	dp[i][m - 1] = val;
        }
        for (int i = m - 2; i >= 0; i--){
        	for (int j = n - m + i; j >= 0; j--){
        		if (T.charAt(i) == S.charAt(j)){
        			dp[j][i] = dp[j + 1][i] + dp[j + 1][i + 1];
        		} else if ((n - j) - (m - i) > 0){
        			dp[j][i] = dp[j + 1][i];
        		}
        	}
        	
        }
        return dp[0][0];
    }

}
