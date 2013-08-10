public class MaximumSubarray {
    static int max;
    public int maxSubArray(int[] A) {
        max = -100000;;
        explore(0, A.length - 1, A);
        return max;
    }
    
    public void explore(int start, int end, int[] A){
        if (start > end) return;
        if (start == end){
            if (A[start] > max) max = A[start];
            return;
        }
        
        int mid = start + (end - start) / 2;
        explore(start, mid, A);
        explore(mid + 1, end, A);
        int leftmax = A[mid];
        int leftsum = A[mid];
        for (int i = mid - 1; i >= start; i--){
            leftsum += A[i];
            if (leftsum > leftmax) leftmax = leftsum;
        }
        int rightmax = A[mid + 1];
        int rightsum = A[mid + 1];
        for (int i = mid + 2; i <= end; i++){
            rightsum += A[i];
            if (rightsum > rightmax) rightmax = rightsum;
        }
        int thismax = leftmax + rightmax;
        if (thismax > max) max = thismax;
    }
}
