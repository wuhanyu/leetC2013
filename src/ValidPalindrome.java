/**
 * 
 */

/**
 * @author Simon
 * @problem Given a string, determine if it is a palindrome, considering only
 *          alphanumeric characters and ignoring cases.
 * 
 *          For example, {@code"A man, a plan, a canal: Panama"} is a
 *          palindrome. {@code""race a car"} is not a palindrome.
 * 
 *          Note: Have you consider that the string might be empty? This is a
 *          good question to ask during an interview.
 * 
 *          For the purpose of this problem, we define empty string as valid
 *          palindrome.
 * 
 * @see http://leetcode.com/onlinejudge#question_125
 * 
 */
public class ValidPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ValidPalindrome().isPalindrome("race a car"));
	}

    public boolean isPalindrome(String s) {
        if (s.equals("")) return true;
        s = s.toLowerCase();
        char[] ch = new char[s.length()];
        int p = 0;
        for (int i = 0; i < s.length(); i++){
        	char c = s.charAt(i);
        	if (isChNum(c)){
        		ch[p] = c;
        		p++;
        	}
        }
        int k = 0;
        p--;
        while (k < p){
        	
        	if (ch[k] != ch[p]) return false;
        	k++;
        	p--;
        }
        return true;
    }
    
    boolean isChNum(char c){
    	if (c - 'a' >= 0 && c - 'a' < 26) return true;
    	if (c - '0' >= 0 && c - '0' < 10) return true;
    	return false;
    }
}
