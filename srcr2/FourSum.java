public class FourSum{
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num.length == 0) return result;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++){
            for (int j = i + 1; j < num.length - 2; j++){
                int k = j + 1;
                int p = num.length - 1;
                while (k < p) {
                    int value = num[i] + num[j] + num[k] + num[p];
                    if (value == target){
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[k]);
                        list.add(num[p]);
                        result.add(list);
                        k++;
                        while (k < p && num[k - 1] == num[k]) k++;
                        p--;
                        while (k < p && num[p + 1] == num[p]) p--;
                    } else if (value > target){
                        p--;
                    } else {
                        k++;
                    }
                }
                while (j < num.length - 2 && num[j] == num[j + 1]) j++;
            }
            while (i < num.length - 2 & num[i] == num[i + 1]) i++;
        }
        return result;
    }
}
