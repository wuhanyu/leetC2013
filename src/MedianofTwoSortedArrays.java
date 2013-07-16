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
		// Start typing your Java solution below
		// DO NOT write main() function
		int ai, bi, aj, bj;
		ai = 0;
		bi = 0;
		aj = A.length - 1;
		bj = B.length - 1;
		int n = A.length + B.length;
		if (n == 0)
			return 0;
		int upper, lower;
		while (n > 0) {
			if (A.length == 0 || ai == A.length)
				bi++;
			else if (B.length == 0 || bi == B.length)
				ai++;
			else if (A[ai] > B[bi])
				bi++;
			else
				ai++;

			if (A.length == 0 || aj < 0)
				bj--;
			else if (B.length == 0 || bj < 0)
				aj--;
			else if (A[aj] < B[bj])
				bj--;
			else
				aj--;
			n -= 2;
		}
		if (A.length == 0)
			lower = B[bi - 1];
		else if (B.length == 0)
			lower = A[ai - 1];
		else if (ai == A.length)
			lower = B[bi];
		else if (bi == B.length)
			lower = A[ai];
		else
			lower = Math.min(A[ai], B[bi]);
		if (A.length == 0)
			upper = B[bj + 1];
		else if(B.length == 0)
			upper = A[aj + 1];
		else if (aj < 0)
			upper = B[bj];
		else if (bj < 0)
			upper = A[aj];
		else
			upper = Math.max(A[ai], B[bi]);
		return (double) (lower + upper) / 2;
	}
}
