//등굣길
class Solution {
    static final int MOD = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        
        boolean[][] map = new boolean[n][m];
        
        for(int i=0; i<puddles.length; ++i)
            map[puddles[i][1]-1][puddles[i][0]-1] = true;
        
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for(int i=1; i<m; ++i)
            if(!map[0][i])
                dp[0][i] = dp[0][i-1];
            else break;
        
        for(int i=1; i<n; ++i)
            if(!map[i][0])
                dp[i][0] = dp[i-1][0];
            else break;
        
        for(int i=1; i<n; ++i)
            for(int j=1; j<m; ++j)
                if(!map[i][j])
                    dp[i][j] = (dp[i-1][j]+dp[i][j-1])%MOD;
        
        return dp[n-1][m-1];
    }
}