import java.util.Arrays;

public class BestTimetoBuyandSellStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2,1,2,0,1};
		System.out.println(new BestTimetoBuyandSellStock().maxProfit(input));
	}

	public int maxProfit(int[] prices) {
		//Extreme input
		if (prices.length == 0) return 0;
		int[][] sums = new int[prices.length][prices.length];
		int[] vals = new int[prices.length];
		for (int i = 1; i < vals.length; i++){
			vals[i] = prices[i] - prices[i - 1];
			sums[i][i] = vals[i];
		}
//		System.out.println(Arrays.toString(vals));
		
		for (int i = 0; i < vals.length; i++){
			for (int j = i + 1; j < vals.length; j++){
				sums[i][j] = sums[i][j-1] + vals[j];
			}
		}
		return maxP(vals, sums, 0, vals.length - 1);	
	}

	int maxP(int[] vals, int[][] sums, int start, int end) {
		if (start == end) return vals[start];
		int max = 0;
		int mid = (start + end) / 2;
		int maxsum = 0;
		for (int i = 0; i <= mid; i++){
			if (sums[i][mid] > maxsum) maxsum = sums[i][mid];
		}
		max += maxsum;
		maxsum = 0;
		for (int i = mid + 1; i <= end; i++){
			if (sums[mid + 1][i] > maxsum) maxsum = sums[mid + 1][i];
		}
		max += maxsum;
		max = Math.max(max, maxP(vals, sums, start, mid));
		max = Math.max(max, maxP(vals, sums, mid + 1, end));
		return max;
	}

}
