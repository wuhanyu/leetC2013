/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_43
 * @problem Given two numbers represented as strings, return multiplication of
 *          the numbers as a string.
 * 
 *          Note: The numbers can be arbitrarily large and are non-negative.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        String nr1 = new StringBuilder(num1).reverse().toString();
        String nr2 = new StringBuilder(num2).reverse().toString();
        char[] result = new char[nr1.length() + nr2.length()];
        for (int i = 0; i < result.length; i++) result[i] = '0';
        int plus = 0;
        for (int i = 0; i < nr2.length(); i++) {
            plus = 0;
            for (int j = 0; j < nr1.length(); j++) {
                int val = (nr1.charAt(j) - '0') * (nr2.charAt(i) - '0') + plus + result[i + j] - '0';
                result[i + j] = (char)('0' + val % 10);
                plus = val / 10;
            }
            if (plus > 0) result[i + nr1.length()] = (char)('0' + plus);
        }
        String str = new String(result);
        int i = str.length() - 1;
        while (str.charAt(i) == '0' && i > 0) i--;
        str = str.substring(0, i + 1);
        return new StringBuilder(str).reverse().toString();
    }
}
