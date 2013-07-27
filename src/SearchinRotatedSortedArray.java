public class SearchinRotatedSortedArray {
    public int search(int[] A, int target) {
        if (A.length == 0) return -1;
        int start = 0;
        int end = A.length - 1;
        while (start < end){
            int mid = start + (end - start) / 2;
            if (A[mid] < A[end]) end = mid;
          else start = mid + 1;
        }
        int rotate = start;
        start = 0;
        end = A.length - 1;
        while (start < end){
        	int mid = start + (end - start) / 2;
        	if (target > A[(mid + rotate) % A.length]){
        		start = mid + 1;
        	} else {
        		end = mid;
        	}
        }
        if (A[(start + rotate) % A.length] == target) return (start + rotate) % A.length;
        else return -1;
    }
}
