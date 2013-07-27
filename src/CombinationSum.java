import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_39
 * @problem Given a set of candidate numbers (C) and a target number (T), find
 *          all unique combinations in C where the candidate numbers sums to T.
 * 
 *          The same repeated number may be chosen from C unlimited number of
 *          times.
 * 
 *          Note:
 * 
 *          All numbers (including target) will be positive integers. Elements
 *          in a combination (a1, a2, � , ak) must be in non-descending order.
 *          (ie, a1 ? a2 ? � ? ak). The solution set must not contain duplicate
 *          combinations. For example, given candidate set 2,3,6,7 and target 7,
 *          A solution set is: [7] [2, 2, 3]
 */
public class CombinationSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int target = 3;
		int[] can = {1, 2};
		System.out.println(new CombinationSum().combinationSum(can, target));
	}

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
        return combination(candidates, target, 0);
    }
    
    public ArrayList<ArrayList<Integer>> combination(int[] candidates, int target, int start) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (target <= 0) return result;
        for (int i = start; i < candidates.length; i++){
            int candidate = candidates[i];
            if (candidate == target){
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(candidate);
                result.add(list);
            } else if (candidate < target){
                ArrayList<ArrayList<Integer>> children = combination(candidates, target - candidate, i);
                for (int j = 0; j < children.size(); j++){
                    children.get(j).add(0, candidate);
                    result.add(children.get(j));
                }
            }
            
        }
        return result;
    }
}
