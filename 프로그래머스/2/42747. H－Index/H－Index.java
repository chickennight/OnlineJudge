class Solution {
    public int solution(int[] citations) {
        int total = citations.length;
        
        int[] cnt = new int[10001];
        
        int max = 0;
        for(int n: citations){
            cnt[n]++;
            max = Math.max(max,n);
        }
        
        int[] dp = new int[max+1];
        
        for(int i=1; i<=max; ++i)
            dp[i] = dp[i-1] + cnt[i];
        
        for(int i=max; i>=1; --i){
            if(dp[max]-dp[i]>=i) 
                return dp[max]-dp[i];
        }
        
        int answer = 0;
        return answer;
    }
}