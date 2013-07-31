import java.util.Arrays;

/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_31
 * @problem Implement next permutation, which rearranges numbers into the
 *          lexicographically next greater permutation of numbers.
 * 
 *          If such arrangement is not possible, it must rearrange it as the
 *          lowest possible order (ie, sorted in ascending order).
 * 
 *          The replacement must be in-place, do not allocate extra memory.
 * 
 *          Here are some examples. Inputs are in the left-hand column and its
 *          corresponding outputs are in the right-hand column. 1,2,3 → 1,3,2
 *          3,2,1 → 1,2,3 1,1,5 → 1,5,1
 */
public class NextPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2};
		new NextPermutation().nextPermutation(num);
	}

    public void nextPermutation(int[] num) {
        if (num.length <= 1) return;
        int p = num.length - 2;
        while (p >= 0 && num[p] >= num[p+1]){
            p--;
        }
        if (p < 0){
            for (int i = 0; i < num.length / 2; i++){
                int tmp = num[i];
                num[i] = num[num.length - i - 1];
                num[num.length - i - 1] = tmp;
            }
        } else {
            int[] unsorted = new int[num.length - p];
            for (int i = p; i < num.length; i++){
                unsorted[i-p] = num[i];
            }
            Arrays.sort(unsorted);
            int k = 0;
            while (unsorted[k] <= num[p]) k++;
            num[p] = unsorted[k];
            for (int i = 0; i < k; i++){
                num[i + p + 1] = unsorted[i];
            }
            for (int i = k + 1; i < num.length - p; i++){
                num[p + i] = unsorted[i];
            }
        }
    }
}
