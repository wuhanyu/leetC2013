import java.util.Arrays;

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_2
 * @problem There are two sorted arrays A and B of size m and n respectively.
 *          Find the median of the two sorted arrays. The overall run time
 *          complexity should be O(log (m+n)).
 */
public class MedianofTwoSortedArrays {
	public static void main(String[] args) {
		int[] A = {1, 1};
		int[] B = {1, 2};
		System.out.println(new MedianofTwoSortedArrays()
				.findMedianSortedArrays(A, B));
	}

	public double findMedianSortedArrays(int A[], int B[]) {
		int n = A.length + B.length;
		if (n == 0) return 0;
		int ai, bi;
		ai = 0;
		bi = 0;
		double median = 0;
		if (n % 2 == 1){
			for (int i = 0; i < n / 2 + 1; i++){
				if (ai == A.length){
					median = B[bi];
					bi++;
				} else if (bi == B.length){
					median = A[ai];
					ai++;
				} else if (A[ai] <  B[bi]){
					median = A[ai];
					ai++;
				} else {
					median = B[bi];
					bi++;
				}
			}
		} else {
			int lower = 0, upper;
			for (int i = 0; i < n / 2; i++){
				if (ai == A.length){
					lower = B[bi];
					bi++;
				} else if (bi == B.length){
					lower = A[ai];
					ai++;
				} else if (A[ai] <  B[bi]){
					lower = A[ai];
					ai++;
				} else {
					lower = B[bi];
					bi++;
				}				
			}
			if (ai == A.length){
				upper = B[bi];
				bi++;
			} else if (bi == B.length){
				upper = A[ai];
				ai++;
			} else if (A[ai] <  B[bi]){
				upper = A[ai];
				ai++;
			} else {
				upper = B[bi];
				bi++;
			}
			median = (double)(upper + lower) / 2;
		}
		return median;
	}
}
