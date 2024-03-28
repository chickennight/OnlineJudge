import java.util.*;

class Solution {
    private int[] dx = {1,-1,0,0};
    private int[] dy = {0,0,1,-1};
    private int n,m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        int[][] record = new int[n][m];
        for(int i=0; i<n; ++i)
            Arrays.fill(record[i],-1);
        
        Queue<int[]> q = new LinkedList<>();
        
        record[0][0] = 1;
        q.add(new int[]{0,0});
        
        int[] now;
        int x,y,nx,ny;
        while(!q.isEmpty()){
            now = q.poll();
            x = now[0];
            y = now[1];
            
            for(int d=0; d<4; ++d){
                nx = x + dx[d];
                ny = y + dy[d];
                if(inRange(nx,ny) && maps[nx][ny]==1 && record[nx][ny] == -1){
                    record[nx][ny] = record[x][y] + 1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        
        return record[n-1][m-1];
    }
    
    private boolean inRange(int x, int y){
        return x>=0 && x<n && y>=0 && y<m;
    }
}