import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_68
 * @problem Given an array of words and a length L, format the text such that
 *          each line has exactly L characters and is fully (left and right)
 *          justified.
 * 
 *          You should pack your words in a greedy approach; that is, pack as
 *          many words as you can in each line. Pad extra spaces ' ' when
 *          necessary so that each line has exactly L characters.
 * 
 *          Extra spaces between words should be distributed as evenly as
 *          possible. If the number of spaces on a line do not divide evenly
 *          between words, the empty slots on the left will be assigned more
 *          spaces than the slots on the right.
 * 
 *          For the last line of text, it should be left justified and no extra
 *          space is inserted between words.
 * 
 *          For example, words: ["This", "is", "an", "example", "of", "text",
 *          "justification."] L: 16.
 * 
 *          Return the formatted lines as:
 * 
 *          [ "This    is    an", "example  of text", "justification.  " ] Note:
 *          Each word is guaranteed not to exceed L in length.
 * 
 *          Corner Cases: A line other than the last line might contain only one
 *          word. What should you do in this case? In this case, that line
 *          should be left-justified.
 */
public class TextJustification {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"What","must","be","shall","be."};
		int L = 12;
		System.out.println(new TextJustification().fullJustify(words, L));
	}

    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>();
        if (words.length == 0) return result;
        int i = 0;
        while (i < words.length){
            int j = i;
            int tl = 0;
            while (j < words.length && tl + words[j].length() <= L){
                tl += words[j].length() + 1;
                j++;
            }
            if (j == words.length){
            	String line = "";
            	for (int k = i; k < j - 1; k++){
            		line += words[k] + " ";
            	}
            	line += words[j-1];
            	int remaining = L - line.length();
            	for (int k = 0; k < remaining; k++) line += " ";
            	result.add(line);
            } else {
	            if (j - i > 1){
	                int bonus = (L + 1 - tl) / (j - i - 1);
	                int extra = (L + 1 - tl) % (j - i - 1);
	                String line = "";
	                for (int k = i; k < j - 1; k++){
	                    line += words[k] + " ";
	                    for (int p = 0; p < bonus; p++) line += " ";
	                    if (extra > 0){
	                        line += " ";
	                        extra--;
	                    }
	                }
	                line += words[j-1];
	                result.add(line);
	            } else {
	                String line = words[i];
	                for (int k = 0; k < L + 1 - tl; k++) line += " ";
	                result.add(line);
	            }
            }
	        i = j;
        }
        return result;
    }
}
