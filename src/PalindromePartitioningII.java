import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_132
 * @problem Given a string s, partition s such that every substring of the
 *          partition is a palindrome.
 * 
 *          Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 *          For example, given s = "aab", Return 1 since the palindrome
 *          partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioningII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abbbc";
		System.out.println(new PalindromePartitioningII().minCut(s));
	}

	public int minCut(String s) {
		char[] chs = s.toCharArray();
		int n = chs.length;
		int[] minp = new int[n];
		boolean[][] isPali = new boolean[n][n];
		minp[0] = 0;
		for (int i = 1; i < n; i++) {
			minp[i] = minp[i - 1] + 1;
			for (int j = i - 1; j >= 0; j--) {
				if (chs[i] == chs[j] && (i - j <= 2 || isPali[j+1][i-1])){
					isPali[j][i] = true;
					if (j == 0)
						minp[i] = 0;
					else
						minp[i] = Math.min(minp[i], minp[j-1] + 1);
				}
			}
		}
		return minp[n - 1];
	}
}
