class Solution {

    public static int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
 
        int[][] sum = new int[N+1][M+1];
        int r1, c1, r2, c2, degree;
        for (int[] order : skill) {
            r1 = order[1];
            c1 = order[2];
            r2 = order[3];
            c2 = order[4];
            degree = order[5] * (order[0] == 1 ? -1 : 1);
 
            sum[r1][c1] += degree;
            sum[r1][c2+1] += (degree * -1);
            sum[r2+1][c1] += (degree * -1);
            sum[r2+1][c2+1] += degree;
        }

        int i,j;
        for (i = 1; i < N; ++i) 
            for (j = 0; j < M; ++j) 
                sum[i][j] += sum[i-1][j];

        for (i = 1; i < M; ++i) 
            for (j = 0; j < N; ++j) 
                sum[j][i] += sum[j][i-1];

        int answer = 0;
        for (i = 0; i < N; ++i) 
            for (j = 0; j < M; ++j) 
                if (board[i][j] + sum[i][j] > 0) 
                    answer++;

        return answer;
    }

}