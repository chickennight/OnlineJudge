class Solution {
    int solution(int[][] land) {
        int len = land.length;

        int[][] dp = new int[len][4];
        dp[0] = land[0];
        for(int i = 1 ; i < len; ++i){
            for(int j = 0 ; j < 4 ; ++j){
                int temp = 0;
                for(int k = 0 ; k < 4 ; ++k){
                    if(k != j){
                        temp = Math.max(dp[i-1][k], temp);
                    }
                }
                dp[i][j] = temp + land[i][j];
            }
        }

        return Math.max(Math.max(Math.max(dp[len-1][0],dp[len-1][1]),dp[len-1][2]),dp[len-1][3]);
    }
}