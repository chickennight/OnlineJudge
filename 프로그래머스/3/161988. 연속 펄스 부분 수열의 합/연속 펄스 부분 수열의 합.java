class Solution {
    public long solution(int[] sequence) {
        int size = sequence.length;
        long[][] dp = new long[size][2];
        long answer = Long.MIN_VALUE;

        dp[0][0] = sequence[0];
        dp[0][1] = -sequence[0];
        answer = Math.max(dp[0][0],dp[0][1]);

        for(int i=1; i<size; ++i){
            dp[i][0] = Math.max(sequence[i], dp[i-1][1]+sequence[i]);
            dp[i][1] = Math.max(-sequence[i], dp[i-1][0]-sequence[i]);
            answer = Math.max(answer, Math.max(dp[i][0],dp[i][1]));
        }

        return answer;
    }
}