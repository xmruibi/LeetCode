package array.medium.stockProblems;

public class StockII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int maxProfit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i] < prices[i + 1]) {
				maxProfit += prices[i + 1] - prices[i];
			}
		}
		return maxProfit;
	}
}
