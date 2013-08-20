/*
Note: sort before processing!
*/
public class TreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if (num.length < 3) return target;
        Arrays.sort(num);
        int min = Integer.MAX_VALUE;
        int minv = 0;
        for (int i = 0; i < num.length - 2; i++){
            int k = i + 1;
            int p = num.length - 1;
            while (k < p){
                int value = num[i] + num[k] + num[p];
                if (Math.abs(target - value) < min){
                    min = Math.abs(target - value);
                    minv = value;
                }
                if (value > target) p--;
                else k++;
            }
        }
        return minv;
    }
}
