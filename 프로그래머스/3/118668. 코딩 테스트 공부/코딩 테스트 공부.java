import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int max_alp = 0;
        int max_cop=0;
        
        for(int[] p: problems){
            max_alp = Math.max(p[0], max_alp);
            max_cop = Math.max(p[1], max_cop);
        }
        
        if(max_alp<=alp && max_cop<=cop)
            return 0;
        
        if(alp >= max_alp)
            alp = max_alp;
    
        if(cop >= max_cop)
            cop = max_cop;
        
        int[][] dp = new int[max_alp+2][max_cop+2];
        
        for(int i = alp; i<=max_alp; ++i)
            for(int j = cop; j<=max_cop; ++j)
                dp[i][j]=Integer.MAX_VALUE;
        
        dp[alp][cop]=0;
        
        for(int i=alp; i<=max_alp; ++i){
            for(int j=cop; j<=max_cop; ++j){
                
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                
                for(int[] p: problems){
                    
                    if(i>=p[0] && j>=p[1]){
                        
                        if(i+p[2]>max_alp && j+p[3]>max_cop)
                            dp[max_alp][max_cop] = Math.min(dp[max_alp][max_cop], dp[i][j]+p[4]);
                        else if(i+p[2]>max_alp)
                            dp[max_alp][j+p[3]] = Math.min(dp[max_alp][j+p[3]], dp[i][j]+p[4]);
                        else if(j+p[3]>max_cop)
                            dp[i+p[2]][max_cop] = Math.min(dp[i+p[2]][max_cop], dp[i][j]+p[4]);
                        else if(i+p[2]<=max_alp && j+p[3]<=max_cop)
                            dp[i+p[2]][j+p[3]] = Math.min(dp[i+p[2]][j+p[3]], dp[i][j]+p[4]); 
                        
                    }   
                    
                }
            }
        }
        
        return dp[max_alp][max_cop];
    }
}