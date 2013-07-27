import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_17
 * @problem Given a digit string, return all possible letter combinations that
 *          the number could represent.
 * 
 *          Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf",
 *          "cd", "ce", "cf"]. Note: Although the above answer is in
 *          lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsofaPhoneNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LetterCombinationsofaPhoneNumber().letterCombinations("23"));
	}
	
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        if (digits.length() == 0){
        	result.add("");
        	return result;
        }

        char[] chset = getChar(digits.charAt(0));
        ArrayList<String> children = 
                letterCombinations(digits.substring(1, digits.length()));
    	for (int i = 0; i < chset.length; i++){
    		for (int j = 0; j < children.size(); j++)
    			result.add(chset[i] + children.get(j));
    	}
     
        return result;
    }
    
    char[] getChar(char ch){
    	char[] chs;
        int dif = ch - '0';
        if (dif <= 1){
           chs = new char[0];
        } else if (dif == 9){
        	String s = "wxyz";
        	chs = s.toCharArray();
        } else if (dif == 8){
        	String s = "tuv";
        	chs = s.toCharArray();        	
        } else if (dif == 7){
        	String s = "pqrs";
        	chs = s.toCharArray();        	
        } else {
           chs = new char[3];
            for (int i = 0; i < 3; i++){
            	chs[i] = (char) ('a' + (dif - 2) * 3 + i); 
            }
        }
        
        return chs;
    }
}
