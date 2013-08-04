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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String num1 = "6913259244";
		String num2 = "0";
		System.out.println(new MultiplyStrings().multiply(num1, num2));
	}

    static int max;
    public String multiply(String num1, String num2) {
        int[] result = new int[1000];
        int[] n1 = reverse(num1.length(), num1.toCharArray());
        int[] n2 = reverse(num2.length(), num2.toCharArray());
               
        max = n1.length;
        for (int i = 0; i < n2.length; i++){
            multi(i, result, n1, n2[i]);
        }
        
        String rs = "";
        boolean start = false;
        for (int i = 0; i < max; i++){
        	if (!start &&  result[max - i - 1] == 0) continue;
        	start = true;
            rs += (char)('0' + result[max - i - 1]);
        }
        if (rs.length() == 0) return "0";
        return rs;
    }
    
    void multi(int start, int[] result, int[] mul1, int mul2){
        int plus = 0;
        for (int i = 0; i < mul1.length; i++){
            int t = mul1[i] * mul2 + result[start + i] + plus;
            result[start + i] = t % 10;
            plus = t / 10;
        }
        if (plus == 0){
        	if (max < start + mul1.length)
        		max = start + mul1.length;
        } else {
        	if (max < start + mul1.length + 1){
        		max = start + mul1.length + 1;
        		result[max - 1] = plus;
        	}
        }
    }
    
    int[] reverse(int n, char[] input){
        int[] result = new int[n];
        for (int i = 0; i < n; i++){
            result[i] = input[n-i-1] - '0';
        }
        return result;
    }
}
