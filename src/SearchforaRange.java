public class SearchforaRange {
    public int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
        if (A.length == 0) return result;
        if (target < A[0] || target > A[A.length - 1]) return result;
        int start = 0;
        int end = A.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (target > A[mid]) start = mid + 1;
            else end = mid - 1;
        }
        int pstart = end;
        start = 0;
        end = A.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (target < A[mid]) end = mid - 1;
            else start = mid + 1;
        }
        int pend = start;
        if (pend - pstart > 1){
            result[0] = pstart + 1;
            result[1] = pend - 1;
        }
        return result;
    }
}
