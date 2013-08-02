public class SortColors {
    public void sortColors(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i <= j && A[i] == 0) i++;
        while (i <= j && A[j] == 2) j--;
        int p = i;
        int k = j;
        while (p <= k){
            if (A[p] == 2){
                A[p] = A[j];
                A[j] = 2;
                j--;
                if (j < k) k = j;
            } else if (A[p] == 0){
                A[p] = A[i];
                A[i] = 0;
                p++;
                i++;
            } else if (A[k] == 0){
                A[k] = A[i];
                A[i] = 0;
                i++;
                if (i > p) p = i;
            } else if (A[k] == 2){
                A[k] = A[j];
                A[j] = 2;
                k--;
                j--;
            } else {
                p++;
                k--;
            }
        }
    }
}
