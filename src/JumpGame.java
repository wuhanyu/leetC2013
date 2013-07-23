public class JumpGame {
    public boolean canJump(int[] A) {
        int rightmost = 0;
        int i = 0;
        while (i <= rightmost && rightmost < A.length - 1){
            if (A[i] + i > rightmost) rightmost = A[i] + i;
            i++;
        }
        if (rightmost >= A.length - 1) return true;
        else return false;
    }
}
