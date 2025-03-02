class Solution {

    // bottom up
    public int maximumScore(int[] nums, int[] multipliers) {
        int m = multipliers.length;
        int n = nums.length;

        int[][] dp = new int[m+1][m+1];

        for (int i = m-1; i >= 0; i--) {
            int mult = multipliers[i];
            for (int left = i; left >= 0; left--) {
                int right = n-1-(i-left);
                dp[i][left] = Math.max(mult*nums[left]+dp[i+1][left+1], mult*nums[right]+dp[i+1][left]);
            }
        }

        return dp[0][0];
    }

    // // top down
    // private int[][] memo;
    // private int[] nums, multipliers;
    // private int n, m;

    // private int dp(int i, int left) {
    // // base - completed all operations + no more to choose from multipliers
    // if (i == m) {
    // return 0;
    // }

    // int right = n - 1 - (i - left);
    // int mult = multipliers[i];

    // // relation
    // if (memo[i][left] == 0) {
    // memo[i][left] = Math.max(mult * nums[left] + dp(i + 1, left + 1), mult *
    // nums[right] + dp(i + 1, left));
    // }

    // return memo[i][left];
    // }

    // public int maximumScore(int[] nums, int[] multipliers) {
    // this.n = nums.length;
    // this.m = multipliers.length;
    // this.nums = nums;
    // this.multipliers = multipliers;
    // this.memo = new int[m][m];

    // return dp(0, 0);
    // }
}