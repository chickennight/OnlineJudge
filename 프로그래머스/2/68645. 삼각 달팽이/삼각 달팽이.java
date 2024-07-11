class Solution {
    public int[] solution(int n) {
        int size = n*(n+1)/2;
        int[] answer = new int[size];
        int[][] arr = new int[n][n];

        int x = -1, y = 0;
        
        int num = 0;
        for (int i=0; i<n; ++i) {
            for (int j=i; j<n; ++j) { 	
                if (i%3 == 0) {
                    ++x;
                } else if (i % 3 == 1) {
                    ++y;
                } else if (i % 3 == 2) {
                    --x;
                    --y;
                }
                arr[x][y] = ++num;
            }
        }
        
        int idx = 0;
        for(int i=0; i<n; ++i) {
            for(int j=0; j<n; ++j) {
                if(arr[i][j] == 0) 
                	break;
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
}