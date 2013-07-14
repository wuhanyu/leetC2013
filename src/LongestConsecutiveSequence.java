import java.util.HashMap;

/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_128
 * @problem Given an unsorted array of integers, find the length of the longest
 *          consecutive elements sequence.
 * 
 *          For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive
 *          elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 *          Your algorithm should run in O(n) complexity.
 * 
 * @note numbers can be duplicated
 */
public class LongestConsecutiveSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 100, 4, 200, 1, 3, 2 };
		System.out.println(new LongestConsecutiveSequence()
				.longestConsecutive(num));
	}

	public int longestConsecutive(int[] num) {
		HashMap<Integer, Integer> left = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> right = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> len = new HashMap<Integer, Integer>();
		int maxlen = 0;
		int length = 0;
		int leftpos, rightpos;
		for (int i = 0; i < num.length; i++) {
			int val = num[i];
			if (len.containsKey(val))
				continue;
			boolean hasleft = len.containsKey(val - 1);
			boolean hasright = len.containsKey(val + 1);
			if (!hasleft && !hasright) {
				length = 1;
				len.put(val, 1);
				left.put(val, val);
				right.put(val, val);
			} else if (hasleft && !hasright) {
				length = len.get(val - 1) + 1;
				leftpos = left.get(val - 1);
				len.put(val, length);
				left.put(val, leftpos);
				right.put(val, val);
				len.put(leftpos, length);
				right.put(leftpos, val);
			} else if (!hasleft && hasright) {
				length = len.get(val + 1) + 1;
				rightpos = right.get(val + 1);
				len.put(val, length);
				left.put(val, val);
				right.put(val, rightpos);
				len.put(rightpos, length);
				left.put(rightpos, val);
			} else if (hasleft && hasright) {
				length = len.get(val - 1) + len.get(val + 1) + 1;
				leftpos = left.get(val - 1);
				rightpos = right.get(val + 1);
				len.put(leftpos, length);
				len.put(rightpos, length);
				len.put(val, length);
				left.put(rightpos, leftpos);
				right.put(leftpos, rightpos);
			}
			maxlen = Math.max(maxlen, length);
		}
		return maxlen;
	}
}
