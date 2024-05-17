import java.util.*;
class Solution {
    
    private class Robot{
        Point p1, p2;
        int t, vertical;
        Robot(Point p1, Point p2, int t, int vertical){
            this.p1 = p1;
            this.p2 = p2;
            this.t = t;
            this.vertical = vertical;
        }
    }
    
    private class Point{
        int r, c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public int solution(int[][] board) {
        int answer = 0;
        Queue<Robot> q = new LinkedList<>();
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        
        int len = board.length;
        boolean[][][] visited = new boolean[len][len][2];
        
        q.add(new Robot(new Point(0, 0), new Point(0, 1), 0, 0));
        
        while(!q.isEmpty()){
            Robot now = q.poll();
            
            if(now.p1.r<0 || now.p1.c<0 || now.p1.r>=len || now.p1.c>=len || now.p2.r<0 || now.p2.c<0 || now.p2.r>=len || now.p2.c>=len) 
                continue;
        
            if(board[now.p1.r][now.p1.c]==1 || board[now.p2.r][now.p2.c]==1) 
                continue;
            
            if(visited[now.p1.r][now.p1.c][now.vertical] && visited[now.p2.r][now.p2.c][now.vertical]) 
                continue;
            
            if((now.p1.r==len-1 && now.p1.c==len-1) || (now.p2.r==len-1 && now.p2.c==len-1)) {
                answer = now.t;
                break;
            }
            
            visited[now.p1.r][now.p1.c][now.vertical] = true;
            visited[now.p2.r][now.p2.c][now.vertical] = true;

            
            for(int i = 0; i < 4; ++i){
                int nr1 = now.p1.r+dr[i];
                int nr2 = now.p2.r+dr[i];
                int nc1 = now.p1.c+dc[i];
                int nc2 = now.p2.c+dc[i];
        
                q.add(new Robot(new Point(nr1, nc1), new Point(nr2, nc2), now.t+1, now.vertical));
            }
            
            if(now.vertical==1){
                if(now.p1.c-1>=0 && board[now.p1.r][now.p1.c-1]==0 && board[now.p2.r][now.p2.c-1]==0){
                    q.add(new Robot(new Point(now.p1.r, now.p1.c), new Point(now.p1.r, now.p2.c-1), now.t+1, 0));
                    q.add(new Robot(new Point(now.p2.r, now.p1.c-1), new Point(now.p2.r, now.p2.c), now.t+1, 0));
                }
                if(now.p1.c+1<len && board[now.p1.r][now.p1.c+1]==0 && board[now.p2.r][now.p2.c+1]==0){
                    q.add(new Robot(new Point(now.p1.r, now.p1.c), new Point(now.p1.r, now.p2.c+1), now.t+1, 0));
                    q.add(new Robot(new Point(now.p2.r, now.p1.c+1), new Point(now.p2.r, now.p2.c), now.t+1, 0));
                }
            }
            else{
                if(now.p1.r-1>=0 && board[now.p1.r-1][now.p1.c]==0 && board[now.p2.r-1][now.p2.c]==0){
                    q.add(new Robot(new Point(now.p1.r-1, now.p2.c), new Point(now.p2.r, now.p2.c), now.t+1, 1));
                    q.add(new Robot(new Point(now.p1.r, now.p1.c), new Point(now.p2.r-1, now.p1.c), now.t+1, 1));
                    
                }
                if(now.p1.r+1<len && board[now.p1.r+1][now.p1.c]==0 && board[now.p2.r+1][now.p2.c]==0){
                    q.add(new Robot(new Point(now.p1.r+1, now.p2.c), new Point(now.p2.r, now.p2.c), now.t+1, 1));   
                    q.add(new Robot(new Point(now.p1.r, now.p1.c), new Point(now.p2.r+1, now.p1.c), now.t+1, 1));   
                }
            }
            
        }
 
        return answer;
    }
}