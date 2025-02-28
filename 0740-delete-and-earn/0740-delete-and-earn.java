class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        int min = 10001;
        int max = 0;
        for (int n : nums) {
            count[n]++;
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        int[] dp = new int[max + 1];
        for (int i = min; i <= max; i++) {
            if(i==1) {
                dp[i] = i*count[i];
                continue;
            }

            dp[i] = Math.max(dp[i-1], dp[i-2]+count[i]*i);
        }

        return dp[max];
    }
}