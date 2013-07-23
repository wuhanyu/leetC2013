/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_8
 * @problem Implement atoi to convert a string to an integer.
 * 
 *          Hint: Carefully consider all possible input cases. If you want a
 *          challenge, please do not see below and ask yourself what are the
 *          possible input cases.
 * 
 *          Notes: It is intended for this problem to be specified vaguely (ie,
 *          no given input specs). You are responsible to gather all the input
 *          requirements up front.
 * 
 *          Requirements for atoi: The function first discards as many
 *          whitespace characters as necessary until the first non-whitespace
 *          character is found. Then, starting from this character, takes an
 *          optional initial plus or minus sign followed by as many numerical
 *          digits as possible, and interprets them as a numerical value.
 * 
 *          The string can contain additional characters after those that form
 *          the integral number, which are ignored and have no effect on the
 *          behavior of this function.
 * 
 *          If the first sequence of non-whitespace characters in str is not a
 *          valid integral number, or if no such sequence exists because either
 *          str is empty or it contains only whitespace characters, no
 *          conversion is performed.
 * 
 *          If no valid conversion could be performed, a zero value is returned.
 *          If the correct value is out of the range of representable values,
 *          INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 * @note 1) number may be over the bound of Integer
 *       2) some errors with mix characters
 *       3) start with zero
 *       4) - / +
 */
public class StringtoInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int atoi(String str) {
		if (str.length() == 0)
			return 0;
		int start = 0;
		while (str.charAt(start) == ' ')
			start++;
		boolean isNeg = false;
		if (start < str.length()
				&& (str.charAt(start) == '-' || str.charAt(start) == '+')) {
			if (str.charAt(start) == '-')
				isNeg = true;
			start++;
		}

		if (start < str.length() && !isInt(str.charAt(start)))
			return 0;
		int val = 0;
		for (int i = start; i < str.length(); i++) {
			if (isInt(str.charAt(i))) {
				if (!isNeg
						&& (val > 214748364 || (val == 214748364 && str
								.charAt(i) - '0' > 7)))
					return Integer.MAX_VALUE;
				if (isNeg
						&& (val > 214748364 || (val == 214748364 && str
								.charAt(i) - '0' > 8)))
					return Integer.MIN_VALUE;
				val *= 10;
				val += str.charAt(i) - '0';
			} else {
				break;
			}
		}
		if (isNeg)
			val *= -1;
		return val;

	}

	boolean isInt(char c) {
		if (c - '0' >= 10 || c - '0' < 0)
			return false;
		return true;
	}
}
