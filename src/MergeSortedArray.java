public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
         int p = A.length - 1;
         m = m - 1;
         n = n - 1;
         while (m >= 0 && n >= 0){
             if (A[m] > B[n]){
                 A[p] = A[m];
                 m--;
             } else {
                 A[p] = B[n];
                 n--;
             }
             p--;
         }
         while (m >= 0){
             A[p] = A[m];
             m--;
             p--;
         }
         while (n >= 0){
             A[p] = B[n];
             n--;
             p--;
         }
    }
}
