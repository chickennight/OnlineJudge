import java.util.*;
 
class Solution {
    static class Point {
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
    static int H,W;
    
    public int solution(String[] board) {
        int answer = Integer.MAX_VALUE;
        H = board.length;
        W = board[0].length();
        
        int[] first = start('R', board);
        
        boolean[][] visit = new boolean[H][W];
        visit[first[0]][first[1]] = true;
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(first[0],first[1],0));
        
        while(!q.isEmpty()) {
            Point now = q.poll();
            
            if (answer <= now.cnt) continue;
            
            if (board[now.x].charAt(now.y) == 'G'){
                answer = Math.min(answer,now.cnt);
                continue;
            }
            
            for (int d = 0; d < 4; ++d) {
                int x = now.x+dx[d];
                int y = now.y+dy[d];
                
                if (x<0 || y<0 || x>=H || y>=W) continue;
                
                if (board[x].charAt(y) == 'D') continue;
                
                while(x>=0 && y>=0 && x<H && y<W && board[x].charAt(y)!='D'){
                    x += dx[d];
                    y += dy[d];
                }
                
                x -= dx[d];
                y -= dy[d];
                
                if (visit[x][y]) continue;
                
                visit[x][y] = true;
                
                q.add(new Point(x, y, now.cnt+1));
            }
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
 
    static int[] start(char target,String[] board) {
        for (int i=0;i<H;++i) {
            String s = board[i];
            for (int j=0;j<W;++j) 
                if (s.charAt(j)==target) 
                    return new int[]{i, j};
        }
        return null;
    }
}
 
