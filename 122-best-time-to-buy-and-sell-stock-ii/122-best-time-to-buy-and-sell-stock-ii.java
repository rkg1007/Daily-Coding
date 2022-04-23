class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int currStockBuyPrice = prices[0], currStockProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= currStockBuyPrice 
                || prices[i] - currStockBuyPrice < currStockProfit) {
                    ans += currStockProfit;
                    currStockBuyPrice = prices[i];
                    currStockProfit = 0;
            } else {
                currStockProfit = prices[i] - currStockBuyPrice;
            }
        }
        return ans + currStockProfit;   
    }
}