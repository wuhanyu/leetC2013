import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        result.add((ArrayList<Integer>)list.clone());
        Arrays.sort(num);
        explore(0, 0, num, list, result);
        return result;
    }
    
    void explore(int level, int start, int[] num, ArrayList<Integer> list, 
        ArrayList<ArrayList<Integer>> result){
        if (level >= num.length) return;
        else {
            for (int i = start; i < num.length; i++){
                list.add(num[i]);
                result.add((ArrayList<Integer>) list.clone());
                explore(level + 1, i + 1, num, list, result);
                while (i < num.length - 1 && num[i] == num[i+1]) i++;
                list.remove(list.size() - 1);
            }
        }
    }
}
