import java.util.Arrays;

class Solution {
    private int[] memo;
    private int[] coins;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        this.coins = coins;
        memo = new int[amount + 1];
        Arrays.fill(memo, -1); // -1 means "not computed yet"

        int result = dp(amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dp(int amount) {
        if (amount == 0) return 0;  // Base case: No coins needed for amount 0
        if (amount < 0) return Integer.MAX_VALUE; // Impossible case
        
        if (memo[amount] != -1) return memo[amount]; // Return cached result

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dp(amount - coin);
            if (res != Integer.MAX_VALUE) { // Only consider valid paths
                minCoins = Math.min(minCoins, res + 1);
            }
        }

        return memo[amount] = minCoins;
    }
}