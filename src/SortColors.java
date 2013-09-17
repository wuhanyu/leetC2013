public class Solution {
    public void sortColors(int[] A) {
        int red = 0;
        int blue = A.length - 1;
        int i = 0;
        while (i <= blue){
            if (A[i] == 0){
                swap(A, i, red);
                red++;
                i++;
            } else if (A[i] == 2) {
                swap(A, i, blue);
                blue--;
            } else {
                i++;
            }
        }
    }
    
    void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
