class Solution {
    int N, result;
    int[][] map;
    int[] rot;
    int[] dx = {0,0,1,-1,0};
    int[] dy = {1,-1,0,0,0};

    
    public int solution(int[][] clockHands) {
        N = clockHands.length;
        map = new int[N][N];
        rot = new int[N];
        for (int i = 0; i < N; ++i) 
            for (int j = 0; j < N; ++j)
                map[i][j] = 4 - clockHands[i][j] == 4 ? 0 : 4-clockHands[i][j];
        
        result = 987654321;
        dfs (0);
        return result;
    }
    
    public void dfs (int ind) {
        if (ind == N) {
            int[][] tmp = new int[N][N];
            int[] cur = new int[N];
            for (int i = 0; i < N; ++i)
                cur[i] = rot[i];
            for (int i = 0; i < N; ++i) 
                for (int j = 0; j < N; ++j)
                    tmp[i][j] = map[i][j];
            

            int tmpRes = 0;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    tmpRes += cur[j];
                    for (int d = 0; d < 5; ++d) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        tmp[nx][ny] = tmp[nx][ny] - cur[j] >= 0 ? tmp[nx][ny] - cur[j] : tmp[nx][ny] - cur[j] + 4;
                    }
                }

                for (int j = 0; j < N; ++j)
                    cur[j] = tmp[i][j];
            }

            boolean tf = true;
            for (int i = 0; i < N; ++i) {
                if (cur[i] != 0) {
                    tf = false;
                    break;
                }
            }
            if (tf) result = Math.min(result, tmpRes);
            return;
        }

        for (int i = 0; i < 4; ++i) {
            rot[ind] = i;
            dfs(ind + 1);
        }
    }
}