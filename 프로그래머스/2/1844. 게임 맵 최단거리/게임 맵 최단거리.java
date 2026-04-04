import java.util.*;

class Solution {
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        int w = maps[0].length;
        int h = maps.length;
        int[][] arr = new int[h][w];
        for(int i=0; i<h; ++i)
            Arrays.fill(arr[i],-1);
        
        Queue<int[]> q = new ArrayDeque<>();
        arr[0][0] = 0;
        q.add(new int[]{0,0});
        int size;
        int cnt = 2;
        while(!q.isEmpty()){
            size = q.size();
            while(size-->0){
                int[] now = q.poll();
                for(int d=0; d<4; ++d){
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];
                    
                    if(nx>=h||nx<0 || ny>=w||ny<0) continue;
                    
                    if(arr[nx][ny]>=0 || maps[nx][ny]==0) continue;
                    
                    arr[nx][ny] = cnt;
                    
                    if(nx==h-1 && ny==w-1) return cnt;
                    
                    q.add(new int[]{nx,ny});
                }
            }
            cnt++;
        }
        
        
        return -1;
    }

}