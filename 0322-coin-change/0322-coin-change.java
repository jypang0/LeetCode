class Solution {

    private int[] memo;
    private int[] coins;
    private int answer;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        Arrays.sort(coins);
        this.coins = coins;

        memo = new int[amount + 1];
        answer = -1;


        dp(amount, 1);


        return answer;
    }

    private void dp(int amount, int depth) {
        for(int i=coins.length-1;i>=0;i--) {
            int curr = amount-coins[i];
            if(curr<0) {
                continue;
            } else {
                if(memo[curr]!=0 && memo[curr]<=depth)
                    continue;

                memo[curr] = depth;

                if(curr==0)
                    answer=answer==-1?depth:Math.min(answer,depth);
                else
                    dp(curr,depth+1);
            }
        }
        // if (answer > 0 && depth >= answer) {
        //     return;
        // }
        // int coin = coins[idx];
        // // impossible
        // if (curr < coin) {
        //     memo[curr][idx] = -1;
        //     return;
        // }

        // // answer
        // if (curr == coin) {
        //     answer = answer == -1 ? depth : Math.min(answer, depth);
        //     return;
        // }

        // // already explored & was faster
        // if (memo[curr][idx] != 0 && memo[curr][idx] <= depth) {
        //     return;
        // }

        // // already explored but was slower
        // // or not explored at all yet
        // memo[curr][idx] = depth;
        // for (int i = coins.length-1; i >= 0; i--) {
        //     dp(curr - coin, i, depth + 1);
        // }
    }
}