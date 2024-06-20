import java.util.*;
class Solution {
    public int solution(int[][] matrix_sizes) {
        
        int size = matrix_sizes.length;
        int[][] dp = new int[size][size];
        
        for(int i = 0; i<size; ++i)
            for(int j = 0; j<size; ++j)
                dp[i][j] = Integer.MAX_VALUE;
        
        int a,b;
        for(int i = 0; i<size; ++i){
            for(int j = 0; j<size-i; ++j){
                a = j;
                b = j+i;
                if(a == b) 
                    dp[a][b] = 0;
                else{
                    for(int k = a; k<b; ++k){
                        dp[a][b] = Math.min(dp[a][b], dp[a][k]+dp[k+1][b]+matrix_sizes[a][0]*matrix_sizes[k][1]*matrix_sizes[b][1]);
                    }
                }
            }
        }
        
        return dp[0][size-1];
    }
}