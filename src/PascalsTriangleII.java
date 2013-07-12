import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Simon@itechs 
 *         Given an index k, return the kth row of the Pascal's
 *         triangle.
 * 
 *         For example, given k = 3, Return [1,3,3,1].
 * 
 *         Note: Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PascalsTriangleII().getRow(32));
	}

	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(1);
		if (rowIndex == 0)
			return result;
		if (rowIndex == 1) {
			result.add(1);
			return result;
		}
		long[] multis = new long[rowIndex / 2];
		multis[0] = rowIndex;
		for (int i = 1; i < rowIndex / 2; i++) {
			multis[i] = multis[i - 1] * (rowIndex - i) / (i + 1);
		}

		for (int i = 1; i <= rowIndex / 2; i++)
			result.add((int) multis[i - 1]);
		for (int i = (rowIndex - 1) / 2; i >= 0; i--)
			result.add(result.get(i));
		return result;
	}
}
