import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num.length == 0) return result;
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++){
            for (int j = i + 1; j < num.length; j++){
                int k = j + 1;
                int p = num.length - 1;
                while (k < p){
                    if (num[k] + num[p] + num[i] + num[j] - target > 0){
                        p--;
                    } else if (num[k] + num[p] + num[i] + num[j] - target < 0){
                        k++;
                    } else {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[k]);
                        list.add(num[p]);
                        result.add(list);
                        p--;
                        k++;
                        while (k < p && k > 0 && num[k] == num[k-1]) k++;
                        while (k < p && p < num.length - 1 && num[p] == num[p+1]) p--;
                    }
                }
                while (j < num.length - 1 && num[j] == num[j+1]) j++;
            }
            while (i < num.length - 1 && num[i] == num[i+1]) i++;
        }
        return result;
    }
}
