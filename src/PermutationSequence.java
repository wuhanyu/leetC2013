/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_60
 * @problem The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 *          By listing and labeling all of the permutations in order, We get the
 *          following sequence (ie, for n = 3):
 * 
 *          "123" "132" "213" "231" "312" "321" Given n and k, return the kth
 *          permutation sequence.
 * 
 *          Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PermutationSequence().getPermutation(3, 1));
	}

    public String getPermutation(int n, int k) {
        int [] f = new int[n];
        if (n == 0) return "";
        if (n == 1) return "1";
        f[1] = 1;
        f[0] = 1;
        for (int i = 2; i < n; i++){
            f[i] = i * f[i-1];
        }
        char[] chs = new char[n];
        boolean[] flag = new boolean[n];
        for (int i = 0; i < n; i++){
            int num = (k - 1) / f[n - i - 1] + 1;
            k = (k - 1) % f[n - i - 1] + 1;
            int p = 0;
            for (p = 0; p < n; p++){
                if (!flag[p]) num--;
                if (num == 0) break;
            }
            flag[p] = true;
            chs[i] = (char)('0' + (p + 1));
        }
        return String.valueOf(chs);
    }
}
