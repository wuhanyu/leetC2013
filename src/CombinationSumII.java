public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
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
                ArrayList<ArrayList<Integer>> children = combination(candidates, target - candidate, i + 1);
                for (int j = 0; j < children.size(); j++){
                    children.get(j).add(0, candidate);
                    result.add(children.get(j));
                }
            }
            while (i < candidates.length - 1 && candidates[i] == candidates[i+1]){
                i++;
            }
        }
        return result;
    }
}
