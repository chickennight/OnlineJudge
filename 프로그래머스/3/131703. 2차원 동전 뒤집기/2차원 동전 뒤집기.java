class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int n = target.length;
        int m = target[0].length;

        int[][] diff = new int[n][m];
        for (int i = 0; i<n; ++i) 
            for (int j = 0; j<m; ++j) 
                diff[i][j] = beginning[i][j] ^ target[i][j];
        
        int sumRow = 0;
        for (int i = 1; i<n; ++i) {
            boolean same = true;
            boolean inverse = true;
            
            for (int j = 0; j<m; ++j) {
                if (diff[i][j] != diff[0][j]) 
                    same = false;
                if ((diff[i][j] ^ 1) != diff[0][j]) 
                    inverse = false;
            }
            
            if (!same) {
                sumRow++;
                if (!inverse) 
                    return -1;
            }
        }

        int sumCol = 0;
        for (int j = 0; j < m; ++j) 
            sumCol += diff[0][j];

        return Math.min(sumRow + sumCol, (n - sumRow) + (m - sumCol));
    }

}