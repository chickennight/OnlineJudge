class Solution {
    final int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m+1][n+1][2];
        dp[1][1][0] = dp[1][1][1] = 1;
        
        int now,i,j;
        for(i = 1 ; i <= m ; ++i){
            for(j = 1 ; j <= n ; ++j){
                now = cityMap[i-1][j-1];
                if(now == 0){
                    dp[i][j][0] += (dp[i-1][j][0] + dp[i][j-1][1]) % MOD;
                    dp[i][j][1] += (dp[i-1][j][0] + dp[i][j-1][1]) % MOD;
                } else if(now == 1){
                      dp[i][j][0] = 0;
                      dp[i][j][1] = 0;
                } else {
                      dp[i][j][0] = dp[i-1][j][0];
                      dp[i][j][1] = dp[i][j - 1][1];
                }
            }
        }
        
        return dp[m][n][0]; 
    }
}