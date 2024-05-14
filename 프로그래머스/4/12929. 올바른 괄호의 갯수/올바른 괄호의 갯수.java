class Solution {
    private int answer = 0;
    
    public int solution(int n) {
        dfs(n*2, 1, 1);
        return answer;
    }
    
    private void dfs(int max, int level, int sum) {
        if(sum < 0) return;
        if(level == max) {
            if(sum == 0) answer++;
            return;
        }
        dfs(max, level+1, sum+1);
        dfs(max, level+1, sum-1);
    }
}