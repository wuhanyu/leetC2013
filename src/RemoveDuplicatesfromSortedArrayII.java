public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] A) {
        boolean[] flag = new boolean[A.length];
        int n = A.length;
        for (int i = 2; i < A.length; i++){
            if (A[i] == A[i-1] && A[i-1] == A[i-2] ) {
                flag[i] = true;
                n--;
            }
        }
        int j = 0;
        for (int i = 0; i < A.length; i++){
            if (!flag[i]){
                A[j] = A[i];
                j++;
            }
        }
        return n;
    }
}
