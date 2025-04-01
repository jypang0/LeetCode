class Solution {
    private int[] prices;
    private int[][][] memo;

    public int maxProfit(int k, int[] prices) {

        this.prices = prices;
        memo = new int[prices.length][k+1][2];

        return dp(0, k, 0);

    }

    private int dp(int i, int t, int h) {
        if(i==prices.length || t==0) return 0;

        if(memo[i][t][h] == 0) {
            if(h==0) { // BUY
                memo[i][t][h] = Math.max(dp(i+1,t,h), -prices[i]+dp(i+1,t,1));
            } else {  // SELL
                memo[i][t][h] = Math.max(dp(i+1,t,h), prices[i]+dp(i+1,t-1,0));
            }
        }

        return memo[i][t][h];
    }
}