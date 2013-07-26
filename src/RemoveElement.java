public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int n = A.length;
        int i = 0;
        while (i < n){
            if (A[i] == elem) {
                A[i] = A[n-1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
