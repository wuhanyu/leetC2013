import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_89
 * @problem The gray code is a binary numeral system where two successive values
 *          differ in only one bit.
 * 
 *          Given a non-negative integer n representing the total number of bits
 *          in the code, print the sequence of gray code. A gray code sequence
 *          must begin with 0.
 * 
 *          For example, given n = 2, return [0,1,3,2]. Its gray code sequence
 *          is:
 * 
 *          00 - 0 01 - 1 11 - 3 10 - 2 Note: For a given n, a gray code
 *          sequence is not uniquely defined.
 * 
 *          For example, [0,2,3,1] is also a valid gray code sequence according
 *          to the above definition.
 * 
 *          For now, the judge is able to judge based on one instance of gray
 *          code sequence. Sorry about that.
 * 
 * @note http://en.wikipedia.org/wiki/Gray_code.
 */
public class GrayCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new GrayCode().grayCode(2));
	}

	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int len = 1 << n;
		for (int i = 0; i < len; i++) {
			result.add((i >> 1) ^ i);
		}
		return result;
	}
}
