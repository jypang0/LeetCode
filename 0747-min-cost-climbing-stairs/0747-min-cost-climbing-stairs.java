class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        
        for(int i=0;i<dp.length;i++) {
            if(i<2) {
                dp[i] = cost[i];
            }
            else {
                dp[i] = Math.min(dp[i-1]+cost[i],dp[i-2]+cost[i]);
            }
        }
        
        return Math.min(dp[dp.length-2], dp[dp.length-1]);
    }
}