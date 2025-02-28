class Solution {
    int[] dp = new int[46];

    public int climbStairs(int n) {
        return dp(n);
    }

    public int dp(int n) {
        if(n<=2) {
            return n;
        } 
        
        if(dp[n]!=0) {
            return dp[n];
        } else {
            return dp[n] = dp(n-1)+dp(n-2);
        }
        
    }
}