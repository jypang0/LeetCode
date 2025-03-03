class Solution {
    // bottom-up
    public int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        int[][] dp = new int[str1.length + 1][str2.length + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[str1.length][str2.length];
    }

    // // top-down
    // private int[][] memo;
    // private char[] str1, str2;

    // private int dp(int i, int j) {
    // // base
    // if (i == str1.length || j == str2.length) {
    // return 0;
    // }

    // if (memo[i][j] >= 0) {
    // return memo[i][j];
    // }

    // if (str1[i] == str2[j]) {
    // memo[i][j] = 1 + dp(i + 1, j + 1);
    // } else {
    // memo[i][j] = Math.max(dp(i, j + 1), dp(i + 1, j));
    // }

    // return memo[i][j];
    // }

    // public int longestCommonSubsequence(String text1, String text2) {
    // this.str1 = text1.toCharArray();
    // this.str2 = text2.toCharArray();
    // this.memo = new int[str1.length][str2.length];
    // for(int[] m:memo) {
    // Arrays.fill(m,-1);
    // }

    // return dp(0, 0);
    // }
}