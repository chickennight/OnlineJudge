class Solution {
    final int MOD = 10007;
    public int solution(int n, int[] tops) {
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];

        a[1] = 1;
        if(tops[0] == 0) b[1] = 2;
        else b[1] = 3;

        for (int i = 2; i<=n; ++i) {
            a[i] = (a[i-1]+b[i-1]) % MOD;
            
            if (tops[i-1] == 1) {
                b[i] = (a[i-1]*2+b[i-1]*3) % MOD;
            } else {
                b[i] = (a[i-1]+b[i-1]*2) % MOD;
            }
        }
        return (a[n]+b[n])%MOD;
    }
}