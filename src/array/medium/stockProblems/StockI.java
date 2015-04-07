package array.medium.stockProblems;

public class StockI {
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int maxProfit = 0;
		int min =Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] - min > maxProfit) {
				max = prices[i];
				maxProfit = max - min;
			} else if(min>prices[i])
				min = prices[i];
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] prices = { 1, 3, 2, 5, 6, 8, 3 };
		System.out.println(maxProfit(prices));
	}
}
