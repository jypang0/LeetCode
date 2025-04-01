class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        int ans = 1;

        for(int i=1;i<nums.length;i++) {
            int max = 1;
            for(int j=0;j<i;j++) {
                if(nums[i]>nums[j]) {
                    max = Math.max(dp[j]+1, max);
                }
            }
            dp[i] = max;
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
}