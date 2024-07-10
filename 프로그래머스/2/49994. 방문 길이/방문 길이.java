class Solution {
    private final int[] dx = {-1,0,1,0};
    private final int[] dy = {0,-1,0,1};
    
    public int solution(String dirs) {
        int[][] map = new int[11][11];
        int x=5, y=5;
        
        char dc;
        int d,nx,ny;
        for(int i=0; i<dirs.length(); ++i){
            d = 0;
            dc = dirs.charAt(i);
            switch (dc){
                case 'D':
                    d = 0;
                    break;
                case 'L':
                    d = 1;
                    break;
                case 'U':
                    d = 2;
                    break;
                case 'R':
                    d = 3;
                    break;
            }
            nx = x + dx[d];
            ny = y + dy[d];
            
            if(nx>10 || nx<0 || ny>10 || ny<0) continue;
            
            map[x][y] = map[x][y] | (1<<d);
            map[nx][ny] = map[nx][ny] | (1<<((d+2)%4));
            x = nx;
            y = ny;
        }
        
        int answer = 0;
        int temp;
        for(int i=0; i<=10; ++i){
            for(int j=0; j<=10; ++j){
                if(map[i][j]>0){
                    temp = map[i][j];
                    while(temp>0){
                        if((temp&1) == 1) ++answer;
                        temp=(temp>>1);
                    }
                }
            }
        }
        
        return answer/2;
    }
}