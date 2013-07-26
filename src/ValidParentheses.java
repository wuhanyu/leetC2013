/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_20
 * @problem Given a string containing just the characters '(', ')', '{', '}',
 *          '[' and ']', determine if the input string is valid.
 * 
 *          The brackets must close in the correct order, "()" and "()[]{}" are
 *          all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ValidParentheses().isValid("()"));
	}

    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        char[] stack = new char[s.length()];
        int top = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (isPL(ch) || top == 0) {
                stack[top] = ch;
                top++;
            } else {
                if (isPair(stack[top - 1], ch)){
                    top--;
                } else {
                    return false;
                }
            }
        }
        if (top == 0)
            return true;
        else
            return false;
    }
    
    boolean isPL(char c){
        if (c == '(' || c == '{' || c == '['){
            return true;
        } else {
            return false;
        }
    }
    
    boolean isPair(char l, char r){
        if (l == '(' && r == ')') return true;
        if (l == '{' && r == '}') return true;
        if (l == '[' && r == ']') return true;
        return false;
    }
}
