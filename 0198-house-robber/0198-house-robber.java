class Solution {

    private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    private int[] nums;

    private int dp(int n) {
        if (n == 0)
            return nums[0];
        if (n == 1)
            return Math.max(nums[1], dp(0));

        if (!memo.containsKey(n)) {
            memo.put(n, Math.max(dp(n - 1), dp(n - 2) + nums[n]));
        }

        return memo.get(n);

    }

    public int rob(int[] nums) {
        this.nums = nums;
        return dp(nums.length - 1);
    }

}