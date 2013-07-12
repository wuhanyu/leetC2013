import java.util.Arrays;

/**
 * @author Simon@itechs
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
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
		int min = prices[0];
		int max = 0;
		for (int i = start; i <= end; i++){
			min = Math.min(min, prices[i]);
			max = Math.max(max, prices[i] - min);
		}
		return max;
	}

}
