/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_6
 * @problem The string "PAYPALISHIRING" is written in a zigzag pattern on a
 *          given number of rows like this: (you may want to display this
 *          pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 *          And then read line by line: "PAHNAPLSIIGYIR" Write the code that
 *          will take a string and make this conversion given a number of rows:
 * 
 *          string convert(string text, int nRows); convert("PAYPALISHIRING", 3)
 *          should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ZigZagConversion().convert("ABCDEFGHI", 4));
	}
	
    public String convert(String s, int nRows) {
    	if (nRows <= 1) return s;
    	int n = s.length();
        char[] chs = s.toCharArray();
        char[] result = new char[n];
        int dis = nRows * 2 - 2;
        int k = 0;
        boolean flag;
        for (int i = 0; i < nRows; i++){
        	int j = i;
        	flag = true;
        	while (j < n){
        		result[k] = chs[j];
        		k++;
        		if (i == 0 || i == nRows - 1) j+= dis;
        		else {
	        		if (flag){
	        			j += dis - 2 * i;
	        			flag = false;
	        		} else {
	        			j += 2 * i;
	        			flag = true;
	        		}
        		}
        	}
        }
        
        return String.valueOf(result);
    }

}
