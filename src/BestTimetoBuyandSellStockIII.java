import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BestTimetoBuyandSellStockIII {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {8,3,6,2,8,8,8,4,2,0,7,2,9,4,9};
		System.out.println(new BestTimetoBuyandSellStockIII().maxProfit(input));
	}

	public int maxProfit(int[] prices) {
		//Extreme input
		if (prices == null || prices.length <= 1) return 0;
		int max = maxP(prices, 0, prices.length - 1);
		for (int i = 1; i < prices.length - 1; i++){
			if (prices[i] >= prices[i + 1] && prices[i] > prices[i - 1])
				max = Math.max(max, maxP(prices, 0, i) + maxP(prices, i + 1, prices.length - 1));
		}
		return max;	
	}

	int maxP(int[] prices, int start, int end) {
		if (start >= end) return 0;
		int min = prices[start];
		int max = 0;
		for (int i = start; i <= end; i++){
			min = Math.min(min, prices[i]);
			max = Math.max(max, prices[i] - min);
		}
		return max;
	}

}
