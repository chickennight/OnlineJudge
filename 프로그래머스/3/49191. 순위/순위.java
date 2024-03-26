class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] arr = new int[n+1][n+1];
        
        for(int i=0; i<results.length; ++i){
            int A = results[i][0];
            int B = results[i][1];
            arr[A][B] = 1; 
            arr[B][A] = -1; 
        }
        
        for(int i=1; i<=n; ++i){
            for(int j=1; j<=n; ++j){
                for(int k=1; k<=n; ++k){
                    if(arr[i][k]==1 && arr[k][j]==1){
                        arr[i][j] = 1;
                        arr[j][i] = -1;
                    }
                    if(arr[i][k]==-1 && arr[k][j]==-1){
                        arr[i][j] = -1;
                        arr[j][i] = 1;
                    }
                }
            }
        }
        
        int temp;
        for(int i=1; i<=n; ++i){
            temp = 0;
            
            for(int j=1; j<=n; ++j)
                if(arr[i][j] != 0) temp++;
            
            if(temp == n-1)
                answer++;
        }
        return answer;
    }
}