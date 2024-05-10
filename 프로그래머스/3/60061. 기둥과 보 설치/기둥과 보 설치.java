import java.util.*;
class Solution {
    private boolean[][] column;
    private boolean[][] beam;
    
    public int[][] solution(int n, int[][] build_frame) {
        column = new boolean[n + 1][n + 1];
        beam = new boolean[n + 1][n + 1];
        
        int count = 0, x, y, type, action;
        for(int[] build: build_frame) {
            x = build[0];
            y = build[1];
            type = build[2];
            action = build[3];
            
            if(type == 0) {
                if(action == 1) {
                    if(checkColumn(x, y)) {
                        column[x][y] = true;
                        count++;
                    }  
                } else {
                    column[x][y] = false;
                    if(deletable(n) == false) column[x][y] = true;
                    else count--;
                }
            } else {
                if(action == 1) {
                    if(checkBeam(x, y)) {
                        beam[x][y] = true;
                        count++;
                    } 
                } else {
                    beam[x][y] = false;
                    if(deletable(n) == false) beam[x][y] = true;
                    else count--;
                }
            }
        }
        
        int[][] result = new int[count][3];
        int idx = 0;
        for(int i = 0; i <= n; ++i) {
            for(int j = 0; j <= n; ++j) {
                if(column[i][j]) {
                    result[idx][0] = i;
                    result[idx][1] = j; 
                    result[idx++][2] = 0;
                }
                if(beam[i][j]) {
                    result[idx][0] = i;
                    result[idx][1] = j;
                    result[idx++][2] = 1;
                }
            }
        }
        return result;
    }
    
    private boolean deletable(int n) {    
        for(int i = 0; i <= n; ++i) { 
            for(int j = 0; j <= n; ++j) { 
                if(column[i][j] && checkColumn(i, j) == false)  return false;
                else if(beam[i][j] && checkBeam(i, j) == false) return false;
            }
        }
        return true;
    }
    
    private boolean checkColumn(int x, int y) {
        if(y == 0) return true;
        else if(y > 0 && column[x][y - 1]) return true;
        else if(x > 0 && beam[x - 1][y] || beam[x][y]) return true;
        return false;
    }
    
    private boolean checkBeam(int x, int y) {
        if(y > 0 && column[x][y - 1] || column[x + 1][y - 1]) return true;
        else if(x > 0 && beam[x - 1][y] && beam[x + 1][y]) return true;
        return false;
    }
}