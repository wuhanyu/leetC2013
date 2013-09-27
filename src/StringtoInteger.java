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
    public int atoi(String str) {
        int start = 0;
        int val = 0;
        while (start < str.length() && str.charAt(start) == ' ') start++;
        int sign = 1;
        if (start < str.length() && (str.charAt(start) == '-' || str.charAt(start) == '+')) {
            if (str.charAt(start++) == '-') sign = -1;
        }
        for (int i = start; i < str.length(); i++) {
            if (isInt(str.charAt(i))) {
                int num = str.charAt(i) - '0';
                if (val > Integer.MAX_VALUE / 10 || (val == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)){
                    if (sign > 0) return Integer.MAX_VALUE;
                    else return Integer.MIN_VALUE;
                }
                val *= 10;
                val += num;
            } else {
                break;
            }
        }
        return val * sign;
    }
    
    boolean isInt(char c) {
        if (c - '0' >= 0 && c -'0' < 10) return true;
        else return false;
    }
}
