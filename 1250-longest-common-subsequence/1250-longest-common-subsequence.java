class Solution {
    
    private int[][] memo;
    private String text1,text2;

    private int dp(int i, int j) {
        // base
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        if (memo[i][j] >= 0) {
            return memo[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + dp(i + 1, j + 1);
        } else {
            memo[i][j] = Math.max(dp(i, j + 1), dp(i + 1, j));
        }

        return memo[i][j];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        this.memo = new int[text1.length()][text2.length()];
        for(int[] m:memo) {
            Arrays.fill(m,-1);
        } 

        return dp(0, 0);
    }
}