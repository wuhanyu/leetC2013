/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_9
 * @problem Determine whether an integer is a palindrome. Do this without extra
 *          space.
 * 
 *          Some hints: Could negative integers be palindromes? (ie, -1)
 * 
 *          If you are thinking of converting the integer to string, note the
 *          restriction of using extra space.
 * 
 *          You could also try reversing an integer. However, if you have solved
 *          the problem "Reverse Integer", you know that the reversed integer
 *          might overflow. How would you handle such case?
 * 
 *          There is a more generic way of solving this problem.
 */
public class PalindromeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PalindromeNumber().isPalindrome(1000110001));
	}
	
    public boolean isPalindrome(int x) {
       if (x < 0) return false;
       int div = (int)Math.pow(10,  (int)Math.floor(Math.log10(x)));
       while (x >= 10){
    	   if (x % 10 == x / div){   
    		   x %= div;
    		   x /= 10;
    		   div /= 100;
    	   } else {
    		   return false;
    	   }
       }
       return true;
    }

}
