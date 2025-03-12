class Solution {
    public int[] countBits(int n) {
        
        if(n==0) return new int[]{0};
        else if(n==1) return new int[]{0,1};

        int[] ans = new int[n+1];
        ans[0] = 0;
        ans[1] = 1;

        int curPow = 1;
        int nextPow = 2;
        for(int i=2;i<=n;i++) {
            if(i==nextPow) {
                ans[i] = 1;
                curPow = nextPow;
                nextPow*=2;
                continue;
            }

            ans[i] = 1 + ans[i-curPow];
        }

        return ans;
    }
}