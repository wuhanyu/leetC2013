public class SearchinRotatedSortedArray {
    public int search(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start < end){
            int mid = start + (end - start) / 2;
            if (A[mid] == target) return mid;
            else if (A[start] <= A[mid]){
                if (target >= A[start] && target < A[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= A[end] && target > A[mid]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }              
            }
        }
        if (A[start] == target) return start;
        else return -1;
    }
}
