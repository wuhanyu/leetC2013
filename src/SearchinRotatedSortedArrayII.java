/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_81
 * @problem Follow up for "Search in Rotated Sorted Array": What if duplicates
 *          are allowed?
 * 
 *          Would this affect the run-time complexity? How and why?
 * 
 *          Write a function to determine if a given target is in the array.
 */
public class SearchinRotatedSortedArrayII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,1, 1};
		int target = 3;
		System.out.println(new SearchinRotatedSortedArrayII().search(A, target));
	}
	
    public boolean search(int[] A, int target) {
        if (A.length == 0) return false;
        int start = 0;
        int end = A.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
        	if (A[mid] == target) return true;
        	if (A[start] < A[mid]){
        		if (target >= A[start] && target < A[mid]){
        			end = mid - 1;
        		} else {
        			start = mid + 1;
        		}
        	} else if (A[mid] < A[end]){
        		if (target > A[mid] && target <= A[end]){
        			start = mid + 1;
        		} else {
        			end = mid - 1;
        		}
        	} else {
        		if (A[start] == target) return true;
        		else start++;
        	}
        }
        return false;
    }

}
