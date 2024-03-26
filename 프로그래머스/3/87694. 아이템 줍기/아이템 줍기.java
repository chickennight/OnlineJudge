import java.util.*;
class Solution {
    static class Point{
        int x;
        int y;
        int cnt;
    
        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        int[][] map = new int[101][101];
        boolean[][] visit = new boolean[101][101];
        
        for(int i=0;i<rectangle.length;++i){
            for(int x=rectangle[i][0]*2;x<=rectangle[i][2]*2;++x){
                for(int y=rectangle[i][1]*2;y<=rectangle[i][3]*2;++y){
                    if(x==rectangle[i][0]*2||x==rectangle[i][2]*2||y==rectangle[i][1]*2||y==rectangle[i][3]*2){
                        if(map[x][y]==0)
                            map[x][y] = 1;
                    }else 
                        map[x][y] = 2;
                }
            }
        }
        int answer = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(characterX*2,characterY*2,0));
        visit[characterX*2][characterY*2] = true;
        int size,nx,ny;
        loop:
        while(!q.isEmpty()){
            size = q.size();

            Point now = q.poll();
                
            if(now.x==itemX*2 && now.y==itemY*2) {
                answer = now.cnt;
                break loop;
            }                                     
                
            for(int d=0;d<4;++d){
                nx = now.x+dx[d];
                ny = now.y+dy[d];
                
                if(nx<0||nx>100||ny<0||ny>100||visit[nx][ny]||map[nx][ny]!=1) continue;

                q.add(new Point(nx,ny,now.cnt+1));
                visit[nx][ny] = true;
                
            }
                        
        }
        
        
        
        return answer/2;
    }
}