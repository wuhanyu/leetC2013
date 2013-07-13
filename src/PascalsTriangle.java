import java.util.ArrayList;

/**
 * @author Simon@itechs
 * @problem Given numRows, generate the first numRows of Pascal's triangle.
 * 
 *          For example, given numRows = 5, Return
 * 
 *          [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 * 
 */
public class PascalsTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PascalsTriangle().generate(3));
	}

	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (numRows == 0)
			return result;
		ArrayList<Integer> init = new ArrayList<Integer>();
		init.add(1);
		result.add(init);
		for (int i = 2; i <= numRows; i++) {
			ArrayList<Integer> newline = getNewLine(init);
			result.add(newline);
			init = newline;
		}
		return result;
	}

	ArrayList<Integer> getNewLine(ArrayList<Integer> input) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(1);
		for (int i = 0; i < input.size() - 1; i++) {
			result.add(input.get(i) + input.get(i + 1));
		}
		result.add(1);
		return result;
	}

}
