import java.util.Arrays;

/**
 * @author Simon@itechs 
 *         Say you have an array for which the ith element is the
 *         price of a given stock on day i.
 * 
 *         Design an algorithm to find the maximum profit. You may complete as
 *         many transactions as you like (ie, buy one and sell one share of the
 *         stock multiple times). However, you may not engage in multiple
 *         transactions at the same time (ie, you must sell the stock before you
 *         buy again).
 */
public class BestTimetoBuyandSellStockII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 2, 1, 2, 0, 1 };
		System.out.println(new BestTimetoBuyandSellStockII().maxProfit(input));
	}

	public int maxProfit(int[] prices) {
		// Extreme input
		if (prices.length == 0)
			return 0;
		int[] vals = new int[prices.length];
		int max = 0;
		for (int i = 1; i < vals.length; i++) {
			vals[i] = prices[i] - prices[i - 1];
			if (vals[i] > 0)
				max += vals[i];
		}
		return max;
	}
}
