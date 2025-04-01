class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];

        for (int i = 0; i < dp.length; i++) {
            for (String word : wordDict) {
                int startIdx = i - word.length() + 1;
                if(startIdx<0) continue;
                if((startIdx > 0 ? dp[startIdx - 1] : true) && (s.substring(startIdx, i + 1).equals(word))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()-1];
    }
}