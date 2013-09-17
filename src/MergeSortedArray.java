public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int bi = B.length - 1;
        int ai = A.length - B.length - 1;
        for (int i = A.length - 1; i >= 0; i--){
            int a = ai >= 0 ? A[ai] : Integer.MIN_VALUE;
            int b = bi >= 0 ? B[bi] : Integer.MIN_VALUE;
            if (a > b) {
                A[i] = a;
                ai--;
            } else {
                A[i] = b;
                bi--;
            }
        }
    }
}
