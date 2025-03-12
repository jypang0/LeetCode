class Solution {
    public int maxProfit(int[] prices) {

        // max profit till now(idx)
        int[] curMaxProfit = new int[prices.length];
        curMaxProfit[0] = 0;

        // Minimum price untill now
        // Should buy at the minimum price
        int curMinPrice = prices[0];

        for(int i=1;i<prices.length;i++) {
            // renew curMinPrice
            curMinPrice = Math.min(curMinPrice, prices[i]);

            // prices[i] - curMinPrice : sell now, buy at the minimum price untill now
            curMaxProfit[i] = Math.max(curMaxProfit[i-1], prices[i]-curMinPrice);
        }
        
        return curMaxProfit[curMaxProfit.length-1];
    }
}