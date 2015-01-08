package Fight;

public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}

		int min = prices[0];
		int profit = 0;

		for (int i = 1; i <= prices.length - 1; i++) {
			min = prices[i] < min ? prices[i] : min;
			profit = prices[i] - min > profit ? prices[i] - min : profit;
		}

		return profit;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
