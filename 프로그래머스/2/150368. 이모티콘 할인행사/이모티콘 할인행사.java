import java.util.*;

class Solution {
    private int n, m;
    private int plus, sell;
    private int[][] user;
    private int[] emots;
    
    public int[] solution(int[][] users, int[] emoticons) {
        n = users.length;
        m = emoticons.length;
        plus = 0;
        sell = 0;
        user = users;
        emots = emoticons;
        
        dfs(new int[m], 0);
    
        return new int[]{plus, sell};
    }
    
    private void dfs(int[] sales, int depth){
        if(depth==m){
            int cnt = 0;
            int sum = 0;
            
            for(int i=0; i<n; ++i){
                int rate = user[i][0];
                int cost = user[i][1];
                int total = 0;
                for(int j=0; j<m; ++j){
                    if(rate<=sales[j]){
                        total += emots[j]*(100-sales[j])/100;
                    }
                }
                if(total>=cost)
                    cnt++;
                else
                    sum+=total;
            }
            
            if(cnt>plus){
                plus = cnt;
                sell = sum;
            }else if(cnt==plus){
                sell = Math.max(sell,sum);
            }
        }else{

        sales[depth] = 10;
        dfs(sales,depth+1);
        sales[depth] = 20;
        dfs(sales,depth+1);
        sales[depth] = 30;
        dfs(sales,depth+1);
        sales[depth] = 40;
        dfs(sales,depth+1);
        }
    }
}