class Solution {
    public int fib(int n) {
        if(n==0 || n==1) return n;

        // n2 = F(n-2), n1 = F(n-1)
        int n2 = 0;
        int n1 = 1;

        for(int nI=2;nI<=n;nI++) {
            int n0 = n1+n2;
            n2 = n1;
            n1 = n0; 
        }

        return n1;
    }
}