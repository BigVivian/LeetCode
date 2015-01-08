package Fight;

public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
		int profit = 0;

		for (int i = 0; i <= prices.length - 2; i++) {
			if (prices[i] < prices[i + 1]) {
				profit += prices[i + 1] - prices[i];
			}
		}
		return profit;
	}

	public static void main(String[] args) {

	}

}
