import java.util.ArrayList;

public class Combinations {
	
	public static void main(String[] args){
		System.out.println(new Combinations().combine(3, 2));
	}
	
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (n <= 0) return result;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) list.add(i+1);
        int p = k;
        while (p >= 0){
            if (p == k) {
                result.add((ArrayList<Integer>) list.clone());
                p--;
            } else {
                int cur = list.get(p);
                if (cur == 0) cur = list.get(p-1) + 1;
                else cur++;
                if (cur == n + 1){          
                    list.set(p, 0);
                    p--;
                } else {
                	list.set(p, cur);
                    p++;
                }
            }
        }
        return result;
    }
}
