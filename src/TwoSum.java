import java.util.HashMap;

/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_1
 * @problem Given an array of integers, find two numbers such that they add up
 *          to a specific target number.
 * 
 *          The function twoSum should return indices of the two numbers such
 *          that they add up to the target, where index1 must be less than
 *          index2. Please note that your returned answers (both index1 and
 *          index2) are not zero-based.
 * 
 *          You may assume that each input would have exactly one solution.
 * 
 *          Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 */
public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++){
        	int number = numbers[i];
        	if (dict.containsKey(target - number)){
        		result[0] = dict.get(target - number);
        		result[1] = i + 1;
        		break;
        	} else {
        		dict.put(number, i + 1);
        	}
        }
        return result;
    }

}
