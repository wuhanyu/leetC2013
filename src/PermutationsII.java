public class PermutationsII {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num.length == 0) return result;
        Arrays.sort(num);
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
                visited[i] = true;
                list.add(num[i]);
                traversal(num, level + 1, visited, list, result);
                visited[i] = false;
                list.remove(list.size() - 1);
                if (i < num.length - 1){
                    while (i < num.length - 1 && num[i] == num[i+1]) i++;
                }
            }
        }
    }
}
