class Solution {
    public int deleteAndEarn(int[] nums) {

        int[] score = new int[10001];
        int min = 10001;
        int max = 0;
        for (int n : nums) {
            score[n] += n;
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        int back2 = 0;
        int back1 = 0;

        for (int i = min; i <= max; i++) {
            int curr = Math.max(back2 + score[i], back1);
            back2 = back1;
            back1 = curr;
        }

        return back1;
    }
}