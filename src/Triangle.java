import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Simon@itechs 
 *         Given a triangle, find the minimum path sum from top to
 *         bottom. Each step you may move to adjacent numbers on the row below.
 * 
 *         For example, given the following triangle
 * 
 *         [ [2], [3,4], [6,5,7], [4,1,8,3] ] The minimum path sum from top to
 *         bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 *         Note: Bonus point if you are able to do this using only O(n) extra
 *         space, where n is the total number of rows in the triangle.
 */
public class Triangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int n = triangle.size();
		if (n == 0)
			return 0;
		ArrayList<Integer> sum = new ArrayList<Integer>();
		sum.add(triangle.get(0).get(0));
		for (int i = 1; i < n; i++) {
			ArrayList<Integer> newline = new ArrayList<Integer>();
			newline.add(sum.get(0) + triangle.get(i).get(0));
			for (int j = 1; j < i; j++) {
				newline.add(Math.min(sum.get(j - 1), sum.get(j))
						+ triangle.get(i).get(j));
			}
			newline.add(sum.get(i - 1) + triangle.get(i).get(i));
			sum = newline;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, sum.get(i));
		}
		return min;
	}

}
