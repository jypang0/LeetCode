class Solution {

    private int[] jobDifficulty;
    private int d;

    private int[][] memo;
    private int[] hardestJobRemaining;

    private int dp(int idx, int day) {

        // base
        if (day == d) {
            return hardestJobRemaining[idx];
        }

        if (memo[idx][day] != -1)
            return memo[idx][day];

        int hardest = jobDifficulty[idx];
        int best = Integer.MAX_VALUE;
        for (int j = idx; j < jobDifficulty.length - (d - day); j++) {
            hardest = Math.max(hardest, jobDifficulty[j]);
            best = Math.min(best, hardest + dp(j + 1, day + 1));
        }
        memo[idx][day] = best;

        return memo[idx][day];
    }

    public int minDifficulty(int[] jobDifficulty, int d) {

        // exception
        if (jobDifficulty.length < d) {
            return -1;
        }

        // init
        this.jobDifficulty = jobDifficulty;
        this.d = d;

        memo = new int[jobDifficulty.length][d + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        hardestJobRemaining = new int[jobDifficulty.length];
        int max = -1;
        for (int i = jobDifficulty.length - 1; i >= 0; i--) {
            max = Math.max(jobDifficulty[i], max);
            hardestJobRemaining[i] = max;
        }

        return dp(0, 1);
    }
}