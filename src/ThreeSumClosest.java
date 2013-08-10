public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if (num.length == 0) return 0;
        Arrays.sort(num);
        int closest = 0;
        int minGap = Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i++){
            int k = i + 1;
            int p = num.length - 1;
            while (k < p){
                int gap = num[k] + num[p] + num[i] - target;
                if (Math.abs(gap) < minGap) {
                    minGap = Math.abs(gap);
                    closest = num[k] + num[p] + num[i];
                }
                if (gap > 0){
                    p--;
                } else if (gap < 0){
                    k++;
                } else {
                    return target;
                }
            }
            while (i < num.length - 1 && num[i] == num[i+1]) i++;
        }
        return closest;
    }
}
