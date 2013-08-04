public class TrappingRainWater {
    public int trap(int[] A) {
        if (A.length == 0) return 0;
        int[] maxLeft = new int[A.length];
        int[] maxRight = new int[A.length];
        maxLeft[0] = A[0];
        for (int i = 1; i < A.length; i++)
            maxLeft[i] = Math.max(maxLeft[i-1], A[i]);
        maxRight[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--)
            maxRight[i] = Math.max(maxRight[i+1], A[i]);
        int result = 0;
        for (int i = 1; i < A.length - 1; i++){
            result += Math.max(0, Math.min(maxLeft[i], maxRight[i]) - A[i]);
        }
        return result;
    }
}
