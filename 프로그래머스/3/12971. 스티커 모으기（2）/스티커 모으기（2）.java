class Solution {
    public int solution(int sticker[]) {
        int size = sticker.length;

        if (size == 1) return sticker[0];

        int[] dp = new int[size];

        dp[0] = sticker[0];
        dp[1] = dp[0];
        int i;
        for (i=2; i<size-1; ++i) 
            dp[i] = Math.max(dp[i-2]+sticker[i], dp[i-1]);
        
        int answer = dp[size-2];

        dp[0] = 0;
        dp[1] = sticker[1];
        for (i=2; i<size; ++i) 
            dp[i] = Math.max(dp[i-2]+sticker[i], dp[i-1]);
        
        answer = Math.max(answer, dp[size-1]);
        return answer;
    }
}