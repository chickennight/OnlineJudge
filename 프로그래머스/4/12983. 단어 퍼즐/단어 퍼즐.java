import java.util.*;
class Solution {
    public int solution(String[] strs, String t) {
        
        Set<String> set = new HashSet<>();
        for(String str: strs)
            set.add(str);
        
        int n = t.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        int idx;
        String target;
        for(int i=1; i<=n; ++i){
            for(int d=1; i-d>=0&&d<=5; ++d){
                target = t.substring(i-d,i);
                if(set.contains(target)){
                    if (dp[i-d] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i-d]+1);
                    }
                }
            }
        }
        return dp[n]==Integer.MAX_VALUE ? -1 : dp[n];
    }
}