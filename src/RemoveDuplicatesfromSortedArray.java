public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
        int n = A.length;
        int j = 1;
        for (int i = 1; i < A.length; i++){
            if (A[i] == A[i-1]) {
                n--;
            } else {
                A[j] = A[i];
                j++;
            }
        }
        return n;
    }
}
