import java.util.*;
class Solution {
    private class Point {
        int x, y, dir, cost;

        public Point(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};
    private boolean[][] visited;
    private int answer;
    private int N;
    private int[][][] dp;

    public int solution(int[][] board) {
        
        answer = Integer.MAX_VALUE;
        N = board.length;
        dp = new int[4][N][N];
        
        for(int d=0; d<4; ++d) 
            for(int i=0; i<N; ++i) 
                for(int j=0; j<N; ++j) 
                    dp[d][i][j] = Integer.MAX_VALUE;
                
        visited = new boolean[N][N];

        bfs(0, 0, -1, 0, board);

        return answer;
    }

    private void bfs(int x, int y, int dir, int cost, int[][] board) {
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y,dir,cost));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Point p = q.poll();
            int px = p.x;
            int py = p.y;
            int pDir = p.dir;
            int pCost = p.cost;

            if(px==N-1 && py==N-1)
                answer = Math.min(answer, pCost);
            
            int nx, ny, nDir, nCost;
            for (int d=0; d<4; ++d) {
                nx = px + dx[d];
                ny = py + dy[d];
                nDir = d;
                nCost = pCost;

                if(nx<0 || nx>=N || ny<0 || ny>=N || board[nx][ny]==1)
                    continue;

                if(pDir == -1)
                    nCost += 100;
                else if(pDir == nDir)
                    nCost += 100;
                else
                    nCost += 600;

                if(!visited[nx][ny] || dp[nDir][nx][ny]>=nCost) {
                    visited[nx][ny] = true;
                    dp[nDir][nx][ny] = nCost;
                    q.add(new Point(nx,ny,nDir,nCost));
                }
            }
        }
    }
}