import java.util.*;

class Solution {
        
    private int[] ans = new int[11];
    private int[] score = new int[11];
    private int[] board = new int[11];
    private int maxScore = 0;
    
    public int[] solution(int n, int[] info) {
        int apeachScore = 0;
        for(int i=0; i<11; ++i){
            if(info[i] > 0){
                apeachScore += (10-i);
                board[i] = (10-i)*2;
            }else{
                board[i] = (10-i);
            }
        }
        
        dfs(n, 10, 0, info);
        
        if(maxScore > apeachScore){
            return ans;
        }
        
        return new int[]{-1};
    }

    private void dfs(int n, int now, int cnt, int[] info){
        if(cnt==n || now==-1){
            int nowScore = getScore();
            
            if(nowScore >= maxScore){
                maxScore = nowScore;
                ans = score.clone();
                ans[10] += (n-cnt);
            }
            return;
        }
        
        dfs(n, now - 1, cnt, info);
        
        if(cnt+info[now]+1 <= n){
            int ryanScore = info[now] + 1;
            score[now] = ryanScore;
            dfs(n, now - 1, cnt+ryanScore, info);
            score[now] = 0;
        }
    }
    
    private int getScore(){
        int ryanScore = 0;
        
        for(int i=10; i>=0; --i){
            if(score[i] > 0){
                ryanScore += board[i];    
            }   
        }
        
        return ryanScore;
    }
    
}