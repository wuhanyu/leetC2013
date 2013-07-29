import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_46
 * @problem Given a collection of numbers, return all possible permutations.
 * 
 *          For example, [1,2,3] have the following permutations: [1,2,3],
 *          [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num = {0, 1};
		System.out.println(new Permutations().permute(num));
	}

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num.length == 0) return result;
        boolean[] visited = new boolean[num.length];
        traversal(num, 0, visited, new ArrayList<Integer>(), result);
        return result;
    }
    
    void traversal(int[] num, int level, boolean[] visited, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result){
        if (level == num.length){
            result.add((ArrayList<Integer>) list.clone());
        } else {
            for (int i = 0; i < num.length; i++){
                if (visited[i]) continue;
                list.add(num[i]);
                visited[i] = true;
                traversal(num, level + 1, visited, list, result);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
