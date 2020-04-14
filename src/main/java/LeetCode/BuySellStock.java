package LeetCode;

public class BuySellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int maxProfit = 0;
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buyPrice) {
                if (maxProfit < (prices[i] - buyPrice)) {
                    maxProfit = prices[i] - buyPrice;
                }
            } else {
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }

}
