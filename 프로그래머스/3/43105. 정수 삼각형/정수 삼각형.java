class Solution {
    public int solution(int[][] triangle) {
        int size = triangle.length;
        int[][] dp = new int[size][size];
        dp[0][0] = triangle[0][0];
        for(int i=1;i<size;++i){
            dp[i][0]=dp[i-1][0]+triangle[i][0];
            dp[i][i]=dp[i-1][i-1]+triangle[i][i];
            for(int j=1;j<i;++j)
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1])+triangle[i][j];
            
        }
        
        int answer = 0;
        for(int i=0;i<size;++i)
            answer= Math.max(dp[size-1][i],answer);
        return answer;
    }
}