/*
* nlog(n)
*/
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        if ((m + n) % 2 == 0)
            return (double)(getKthNumber(A, 0, m, B, 0, n, (m + n) / 2) + getKthNumber(A, 0, m, B, 0, n, (m + n) / 2 + 1)) / 2;
        else
            return (double)getKthNumber(A, 0, m, B, 0, n, (m + n) / 2 + 1);
    }
    
    int getKthNumber(int[] A, int as, int ae, int[] B, int bs, int be, int k){
        if (as >= ae) return B[bs + k - 1];
        if (bs >= be) return A[as + k - 1];
        if (k <= 1) return Math.min(A[as], B[bs]);
        int am = as + (ae - as) / 2;
        int bm = bs + (be - bs) / 2;
        if (A[am] <= B[bm]){
            if (am - as + bm - bs + 1 >= k) return getKthNumber(A, as, ae, B, bs, bm, k);
            else return getKthNumber(A, am + 1, ae, B, bs, be, k - am + as - 1);
        } else {
            if (am - as + bm - bs + 1 >= k) return getKthNumber(A, as, am, B, bs, be, k);
            else return getKthNumber(A, as, ae, B, bm + 1, be, k - bm + bs - 1);
        }
    }
}
