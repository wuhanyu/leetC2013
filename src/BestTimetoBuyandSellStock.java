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
		if (prices == null || prices.length <= 1) return 0;
		
		return maxP(prices, 0,prices.length - 1);	
	}

	int maxP(int[] prices, int start, int end) {
		if (start == end) return 0;
		int mid = (start + end) / 2;
		int max = 0;
		int maxval = Integer.MIN_VALUE;
		int minval = Integer.MAX_VALUE;
		for (int i = start; i <= mid; i++) minval = Math.min(minval, prices[i]);
		for (int i = mid + 1; i <= end; i++) maxval = Math.max(maxval, prices[i]);
		max = maxval - minval;
		max = Math.max(max, maxP(prices, start, mid));
		max = Math.max(max, maxP(prices, mid + 1, end));
		return max;
	}

}
