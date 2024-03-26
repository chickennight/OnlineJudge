class Solution {
    private final int[] dx = {1,0,0,-1};
    private final int[] dy = {0,-1,1,0};
    private final char[] dc = {'d','l','r','u'};
    private int N,M,R,C,K;
    private String answer;
    private StringBuilder sb;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        R = r;
        C = c;
        K = k;
        
        int diff = (int)Math.abs(x-r) + (int)Math.abs(y-c);
        if((k - diff) % 2 == 1 || k < diff) return "impossible";
        
        sb = new StringBuilder();
        answer = null;
        
        dfs(x,y,0);
        
        if(answer == null) answer = "impossible";
        
        return answer;
    }
    
    private void dfs(int x, int y, int depth){
        
        if(answer != null) return;
        
        if(depth+(int)Math.abs(x-R)+(int)Math.abs(y-C) > K) return;
        
        if(depth == K) {
            answer = sb.toString();
            return;
        }
        
        for(int d=0; d<4; ++d){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx<=N && nx>0 && ny<=M && ny>0){
                sb.append(dc[d]);
                dfs(nx, ny, depth+1);
                sb.delete(depth, depth+1);
            } 
        }

    }
}