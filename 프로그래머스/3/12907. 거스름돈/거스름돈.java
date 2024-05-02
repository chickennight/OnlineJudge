class Solution {
    private final int MOD = 1000000007;
        
    public int solution(int n, int[] money) {
        int[][] dp = new int[money.length+1][n+1];
        
        for(int i = 1; i < money.length+1; ++i){
            for(int j = 0; j < n+1; ++j){
                if(j == 0)
                    dp[i][j] = 1;
                else {
                    if(j < money[i-1])
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = (dp[i-1][j] + dp[i][j-money[i-1]]) % MOD;
                }
            }
        }
        return dp[money.length][n];
    }
}