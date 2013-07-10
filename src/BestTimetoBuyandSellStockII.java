import java.util.Arrays;

public class BestTimetoBuyandSellStockII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2,1,2,0,1};
		System.out.println(new BestTimetoBuyandSellStockII().maxProfit(input));
	}

	public int maxProfit(int[] prices) {
		//Extreme input
		if (prices.length == 0) return 0;
		int[] vals = new int[prices.length];
		int max = 0;
		for (int i = 1; i < vals.length; i++){
			vals[i] = prices[i] - prices[i - 1];
			if (vals[i] > 0) max += vals[i];
		}
		return max;
	}
}
