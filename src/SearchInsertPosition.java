public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (target > A[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return end + 1;
    }
}
