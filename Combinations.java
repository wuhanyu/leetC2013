public class Combinations {
    static ArrayList<ArrayList<Integer>> result;
    static boolean[] flag;
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        result = new ArrayList<ArrayList<Integer>>();
        if (n < k) return result;
        flag = new boolean[n];
        traversal(1, k, n, 0, new ArrayList<Integer>());
        return result;
    }
    
    void traversal(int p, int k, int n, int start, ArrayList<Integer> list){
        if (p > k) result.add((ArrayList<Integer>) list.clone());
        else {
            for (int i = start; i < n; i++){
                if (!flag[i]){
                    list.add(i + 1);
                    flag[i] = true;
                    traversal(p + 1, k, n, i+1, list);
                    list.remove(list.size() - 1);
                    flag[i] = false;
                }
            }
        }
    }
}
