
class Solution {
    private static int[] dx = {1,-1,0,0,1,1,-1,-1};
    private static int[] dy = {0,0,1,-1,1,-1,1,-1};
    
    public int[] solution(String[][] places) {
        int[] ans = new int[5];
        for(int i=0; i<5; ++i)
            ans[i] = solve(places[i]);
        
        return ans;
    }
    
    private int solve(String[] place){
        for(int i=0; i<5; ++i){
            for(int j=0; j<5; ++j){
                if(place[i].charAt(j)=='P'){
                    for(int d=0; d<4; ++d){
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if(!inRange(nx,ny)) 
                            continue;
                        if(place[nx].charAt(ny)=='P') 
                            return 0;
                    }
                    for(int d=0; d<4; ++d){
                        int nx = i + 2*dx[d];
                        int ny = j + 2*dy[d];
                        if(!inRange(nx,ny)) 
                            continue;
                        if(place[nx].charAt(ny)=='P') {
                            if(place[i+dx[d]].charAt(j+dy[d])=='X')
                                continue;
                            else
                                return 0;
                        };
                    }
                    for(int d=4; d<8; ++d){
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if(!inRange(nx,ny)) 
                            continue;
                        if(place[nx].charAt(ny)=='P'){
                            if(place[nx].charAt(j)=='X'&&place[i].charAt(ny)=='X')
                                continue;
                            else
                                return 0;
                        } 
                    }
                }
            }
        }
        return 1;
    }
    
    private static boolean inRange(int x, int y){
        return x<5 && x>=0 && y<5 && y>=0;
    }
}