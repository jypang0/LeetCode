class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int answer = 0;

        // initialize dp array
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] - '0';
                if (dp[i][j] == 1) {
                    answer = 1;
                }
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (dp[i][j]==0) {
                    continue;
                }

                int right = dp[i][j + 1];
                int bottom = dp[i + 1][j];
                int diag = dp[i + 1][j + 1];

                dp[i][j] = Math.min(right, Math.min(bottom, diag)) + 1;

                answer = Math.max(dp[i][j], answer);
            }
        }

        return answer*answer;
    }
}