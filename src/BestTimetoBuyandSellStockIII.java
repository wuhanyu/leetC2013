import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BestTimetoBuyandSellStockIII {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,4,2,5,7,2,4,9,0,9};
		System.out.println(new BestTimetoBuyandSellStockIII().maxProfit(input));
	}

	public int maxProfit(int[] prices) {
		//Extreme input
		if (prices == null || prices.length <= 1) return 0;
		int max = 0;
		Map<String, Integer> dict = new HashMap<String, Integer>();
		for (int i = 0; i < prices.length; i++){
			if (i == (prices.length - 1)|| (prices[i + 1] - prices[i] <= 0))
				max = Math.max(max, maxP(prices, 0, i, dict) + maxP(prices, i + 1, prices.length - 1, dict));
		}
		return max;	
	}

	int maxP(int[] prices, int start, int end, Map<String, Integer> dict) {
		if (start >= end) return 0;
		String key = getKey(start, end);
		if (dict.containsKey(key)) {
			return dict.get(key);
		}
		int mid = (start + end) / 2;
		int max = 0;
		int maxval = Integer.MIN_VALUE;
		int minval = Integer.MAX_VALUE;
		for (int i = start; i <= mid; i++) minval = Math.min(minval, prices[i]);
		for (int i = mid + 1; i <= end; i++) maxval = Math.max(maxval, prices[i]);
		max = maxval - minval;
		max = Math.max(max, maxP(prices, start, mid, dict));
		max = Math.max(max, maxP(prices, mid + 1, end, dict));
		dict.put(key, max);
		return max;
	}
	
	String getKey(int start, int end){
		return start + ":" + end;
	}

}
