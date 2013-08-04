import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_51
 * @problem The n-queens puzzle is the problem of placing n queens on an n�n
 *          chessboard such that no two queens attack each other.
 * 
 *          Given an integer n, return all distinct solutions to the n-queens
 *          puzzle.
 * 
 *          Each solution contains a distinct board configuration of the
 *          n-queens' placement, where 'Q' and '.' both indicate a queen and an
 *          empty space respectively.
 * 
 *          For example, There exist two distinct solutions to the 4-queens
 *          puzzle:
 * 
 *          [ [".Q..", // Solution 1 "...Q", "Q...", "..Q."],
 * 
 *          ["..Q.", // Solution 2 "Q...", "...Q", ".Q.."] ]
 */
public class NQueens {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new NQueens().solveNQueens(3);
	}
	
	static boolean[] x, xy, xyn;
	static int[] pos;
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        x = new boolean[n];
        xy = new boolean[2 * n - 1];
        xyn = new boolean[2 * n - 1];
        pos = new int[n];
        explore(0, n, result);
        return result;
    }
    
    void explore(int level, int n, ArrayList<String[]> result){
    	if (level == n) result.add(output());
    	else {
    		for (int i = 0; i < n; i++){
    			if (!x[i] && !xy[n - level + i - 1] && !xyn[level + i]){
    				x[i] = true;
    				xy[n - level + i - 1] = true;
    				xyn[level + i] = true;
    				pos[level] = i;
    				explore(level + 1, n, result);
    				x[i] = false;
    				xy[n - level + i - 1] = false;
    				xyn[level + i] = false;
    			}
    		}
    	}
    }

    String[] output(){
    	String[] result = new String[pos.length];
    	for (int i = 0; i < pos.length; i++){
    		String line = "";
    		for (int j = 0; j < pos[i]; j++) line += ".";
    		line += "Q";
    		for (int j = pos[i] + 1; j < pos.length; j++) line += ".";
    		result[i] = line;
    	}
    	return result;
    }
}
