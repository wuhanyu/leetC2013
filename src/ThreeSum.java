public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        explore(0, 0, 0, num, new ArrayList<Integer>(), result);
        return result;
    }
    
    void explore(int level, int start, int sum, int[] num, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result){
        if (level == 3) {
            if (sum == 0) {
                result.add((ArrayList<Integer>)list.clone());
            }
        } else {
            for (int i = start; i < num.length; i++){
                list.add(num[i]);
                explore(level + 1, i + 1, sum + num[i], num, list, result);
                while (i < num.length - 1 && num[i] == num[i+1]) i++;
                list.remove(list.size() - 1);
            }
        }
    }
}
