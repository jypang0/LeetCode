class Solution {

    // bottom up
    
    public int minDifficulty(int[] jobDifficulty, int d) {

        int n = jobDifficulty.length;
        if(n < d) {
            return -1;
        }

        int[][] dp = new int[n][d+1];
        for(int[] temp:dp) {
            Arrays.fill(temp,Integer.MAX_VALUE);
        }
        
        dp[n-1][d] = jobDifficulty[n-1];
        for(int i=n-2;i>=0;i--) {
            dp[i][d] = Math.max(dp[i+1][d], jobDifficulty[i]);
        }

        for (int day = d - 1; day > 0; day--) {
            for (int i = day - 1; i < n - (d - day); i++) {
                int hardest = 0;
                for (int j = i; j < n - (d - day); j++) {
                    hardest = Math.max(hardest, jobDifficulty[j]);
                    dp[i][day] = Math.min(dp[i][day], hardest + dp[j + 1][day + 1]);
                }
            }
        }

        return dp[0][1];
    }

    // // top down
    // private int[] jobDifficulty;
    // private int d;

    // private int[][] memo;
    // private int[] hardestJobRemaining;

    // private int dp(int idx, int day) {

    //     // base
    //     if (day == d) {
    //         return hardestJobRemaining[idx];
    //     }

    //     if (memo[idx][day] != -1)
    //         return memo[idx][day];

    //     int hardest = jobDifficulty[idx];
    //     int best = Integer.MAX_VALUE;
    //     for (int j = idx; j < jobDifficulty.length - (d - day); j++) {
    //         hardest = Math.max(hardest, jobDifficulty[j]);
    //         best = Math.min(best, hardest + dp(j + 1, day + 1));
    //     }
    //     memo[idx][day] = best;

    //     return memo[idx][day];
    // }

    // public int minDifficulty(int[] jobDifficulty, int d) {

    //     // exception
    //     if (jobDifficulty.length < d) {
    //         return -1;
    //     }

    //     // init
    //     this.jobDifficulty = jobDifficulty;
    //     this.d = d;

    //     memo = new int[jobDifficulty.length][d + 1];
    //     for (int[] m : memo) {
    //         Arrays.fill(m, -1);
    //     }

    //     hardestJobRemaining = new int[jobDifficulty.length];
    //     int max = -1;
    //     for (int i = jobDifficulty.length - 1; i >= 0; i--) {
    //         max = Math.max(jobDifficulty[i], max);
    //         hardestJobRemaining[i] = max;
    //     }

    //     return dp(0, 1);
    // }
}