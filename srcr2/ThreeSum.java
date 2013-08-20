/*
be careful with the duplicates
*/
public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num.length == 0) return result;
        Arrays.sort(num);
        int count = 0;
        for (int i = 0; i < num.length - 2; i++){
            int k = i + 1;
            int p = num.length - 1;
            while (k < p){
                int value = num[i] + num[k] + num[p];
                if (value == 0){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[k]);
                    list.add(num[p]);
                    result.add(list);
                    k++;
                    while (k < p && num[k - 1] == num[k]) k++;
                    p--;
                    while (k < p && num[p + 1] == num[p]) p--;
                } else if (value > 0){
                    p--;
                } else {
                    k++;
                }
            }
            while (i < num.length - 2 && num[i] == num[i + 1]) i++;
        }
        return result;
    }
}
