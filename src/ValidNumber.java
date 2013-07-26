/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_65
 * @problem Validate if a given string is numeric.
 * 
 *          Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" =>
 *          false "2e10" => true
 * 
 *          Note: It is intended for the problem statement to be ambiguous. You
 *          should gather all requirements up front before implementing one.
 * 
 * @note very complicated= =
 */
public class ValidNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ValidNumber().isNumber(".34"));
	}

	public boolean isNumber(String s) {
		s = trim(s);
		if (isInt(s))
			return true;
		else if (isReal(s)) {
			return true;
		} else if (isSci(s)) {
			return true;
		} else {
			return false;
		}
	}

	public String trim(String s) {
		if (s.length() == 0)
			return s;
		int i = 0;
		while (i < s.length() && s.charAt(i) == ' ')
			i++;
		if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-'))
			i++;
		if (i == s.length())
			return "";
		int j = s.length() - 1;
		while (j >= 0 && s.charAt(j) == ' ')
			j--;
		return s.substring(i, j + 1);
	}

	public boolean isInt(String s) {
		if (s.length() == 0)
			return false;
		for (int i = 0; i < s.length(); i++) {
			int dif = s.charAt(i) - '0';
			if (dif < 0 || dif >= 10)
				return false;
		}
		return true;
	}

	public boolean isReal(String s) {
		if (isInt(s))
			return true;
		if (s.length() < 2)
			return false;
		String[] tmp = s.split("\\.");
		if (tmp.length == 1 && tmp[0].length() == s.length() - 1) {
			if (isInt(tmp[0]))
				return true;
			else
				return false;
		}
		if (tmp.length != 2)
			return false;
		String left = tmp[0];
		String right = tmp[1];
		if (left.length() + right.length() != s.length() - 1)
			return false;
		boolean isIntLeft = isInt(left);
		boolean isIntRight = isInt(right);
		if (left.length() == 0 && isIntRight)
			return true;
		if (isIntLeft && isIntRight)
			return true;
		return false;
	}

	public boolean isSci(String s) {
		if (s.length() < 2)
			return false;
		String[] tmp = s.split("e");
		if (tmp.length != 2)
			return false;
		String left = tmp[0];
		String right = tmp[1];
		if (left.length() + right.length() != s.length() - 1)
			return false;
		if (right.length() > 0
				&& (right.charAt(0) == '+' || right.charAt(0) == '-'))
			right = right.substring(1, right.length());
		if (isReal(left) && isInt(right)) {
			return true;
		} else {
			return false;
		}
	}
}
