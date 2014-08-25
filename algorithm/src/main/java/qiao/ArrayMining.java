package qiao;

public class ArrayMining {

	/**
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * If you were only permitted to buy one share of the stock and sell one
	 * share of the stock, design an algorithm to find the best times to buy and
	 * sell.
	 */
	public static int findMaxDiff(int[] prices) {
		if (prices == null || prices.length == 1) {
			throw new IllegalArgumentException();
		}

		int minInd = 0;
		int maxInd = 0;
		int maxDiff = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < prices[minInd]) {
				minInd = i;
			}
			if (maxDiff < (prices[i] - prices[minInd])) {
				maxDiff = prices[i] - prices[minInd];
				maxInd = i;
			}
		}
		System.out.println("best time to buy: " + minInd);
		System.out.println("best time to sell: " + maxInd);
		System.out.println("maximum gain: " + maxDiff);
		return maxDiff;
	}

}
