class Solution {
    public int[] solution(int target) {
        
        int[][] dp = new int[target+1][2];
        for(int[] arr: dp)
            arr[0] = Integer.MAX_VALUE;
        
        dp[0][0] = 0;
        for(int i=1; i<=target; ++i){ 
            for(int j=1; j<=20; ++j){ 
                
                // 불
                if(i-50 >= 0){
                    if(dp[i][0] > dp[i-50][0]+1){
                        dp[i][0] = dp[i-50][0]+1;
                        dp[i][1] = dp[i-50][1]+1;
                    }else if(dp[i][0] == dp[i-50][0]+1){
                        dp[i][1] = Math.max(dp[i][1], dp[i-50][1]+1); 
                    }
                    
                }
                
                // 싱글
                if(i-j >= 0){
                    if(dp[i][0] > dp[i-j][0]+1){
                        dp[i][0] = dp[i-j][0]+1;
                        dp[i][1] = dp[i-j][1]+1;
                    }else if(dp[i][0] == dp[i-j][0]+1){
                        dp[i][1] = Math.max(dp[i][1], dp[i-j][1]+1); 
                    }
                }
                
                // 더블
                if(i-2*j >= 0){
                    if(dp[i][0] > dp[i-2*j][0]+1){
                        dp[i][0] = dp[i-2*j][0]+1;
                        dp[i][1] = dp[i-2*j][1];
                    }
                    
                }
                
                //트리플
                if(i-3*j >= 0){
                    if(dp[i][0] > dp[i-3*j][0]+1){
                        dp[i][0] = dp[i-3*j][0]+1; 
                        dp[i][1] = dp[i-3*j][1];
                    }
                }

            }
        }
        
        return dp[target];
    }
}