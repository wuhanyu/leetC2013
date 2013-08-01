/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_29
 * @problem Divide two integers without using multiplication, division and mod
 *          operator.
 */
public class DivideTwoIntegers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int dividend = -1;
		int divisor = 1;
		System.out.println(new DivideTwoIntegers().divide(dividend, divisor));
	}

    public int divide(int dividend, int divisor) {       
        boolean isNeg = false;
        if (dividend > 0 && divisor < 0) isNeg = true;
        if (dividend < 0 && divisor > 0) isNeg = true;       
        long dd = Math.abs((long)dividend);
        long dr = Math.abs((long)divisor);
        if (dd < dr) return 0;
        if (dr == 1){
        	if (isNeg) return (int) (dd * -1);
        	else return (int) dd;
        }
        int result = 0;
        int count = 1;
        while (dd > 0){
            dd -= count * dr;
            result += count;
            if (dd < -dr){
                dd += count * dr;
                result -= count;
                count = 1;
            } else {
                count *= 2;
            }
        }
        if (dd < 0) result -= 1;
        if (isNeg) return result * -1;
        else return result;
    }
}
