import java.util.*;
class Solution {
    
    public class Block {
        int sx, ex, sy, ey;

        public Block (int sx, int ex, int sy, int ey) {
            this.sx = sx;
            this.ex = ex;
            this.sy = sy;
            this.ey = ey;
        }
    }

    public int N;
    
    public int solution(int[][] board) {
        N = board.length;

        int blockCnt = 0;
        for(int i=0; i<N; ++i)
            for(int j=0; j<N; ++j)
                blockCnt = Math.max(blockCnt, board[i][j]);
        
        Block[] blocks = new Block[blockCnt + 1];
        for(int i=0; i<blockCnt+1; ++i)
            blocks[i] = new Block(50, -1, 50, -1);
        
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                int now = board[i][j];
                if(now == 0) continue;
                blocks[now].sx = Math.min(blocks[now].sx, i);
                blocks[now].ex = Math.max(blocks[now].ex, i);
                blocks[now].sy = Math.min(blocks[now].sy, j);
                blocks[now].ey = Math.max(blocks[now].ey, j);
            }
        }

        int[] bounds = new int[N];
        Arrays.fill(bounds, -1);
        for(int j=0; j<N; ++j){
            for(int i=0; i<N; ++i){
                if(board[i][j] == 0) continue;
                bounds[j] = i;
                break;
            }
            if(bounds[j] == -1)
                bounds[j] = N;
        }

        int result = 0;
        while(true){
            boolean isBroken = false;

            for(int idx=0; idx<N; ++idx){
                if(bounds[idx] == N) continue;
                int now = board[bounds[idx]][idx];

                boolean end = false;
                for(int i=blocks[now].sx; i<=blocks[now].ex; ++i){
                    for(int j=blocks[now].sy; j<=blocks[now].ey; ++j){
                        if(board[i][j] == now) continue;
                        if(board[i][j]==0 && bounds[j]>i) continue;
                        end = true;
                        break;
                    }
                    if(end) break;
                }
                
                if(end) continue;

                result++;
                isBroken = true;

                for(int i=blocks[now].sx; i<=blocks[now].ex; ++i)
                    for(int j=blocks[now].sy; j<=blocks[now].ey; ++j)
                        if (board[i][j] == now)
                            board[i][j] = 0;
                    
                for(int j=blocks[now].sy; j<=blocks[now].ey; ++j){
                    bounds[j] = -1;
                    for(int i=0; i<N; ++i){
                        if(board[i][j] == 0) continue;
                        bounds[j] = i;
                        break;
                    }
                    
                    if (bounds[j] == -1)
                        bounds[j] = N;
                }
            }

            if (!isBroken) break;
        }
        
        return result;
    }
}