public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1;
        int j = n - 1;
        for (int p = m + n - 1; p >= 0; p--) {
            int a = i >= 0 ? A[i] : Integer.MIN_VALUE;
            int b = j >= 0 ? B[j] : Integer.MIN_VALUE;
            if (a < b) {
                A[p] = b;
                j--;
            } else {
                A[p] = a;
                i--;
            }
        }
    }
}
