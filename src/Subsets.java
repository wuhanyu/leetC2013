import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(S);
        traversal(0, S, new ArrayList<Integer>(), result);
        return result;
    }
    
    void traversal(int n, int[]S, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result){
        if (n == S.length) result.add((ArrayList<Integer>) list.clone());
        else {
            traversal(n + 1, S, list, result);
            list.add(S[n]);
            traversal(n + 1, S, list, result);
            list.remove(list.size() - 1);
        }
    }
}
