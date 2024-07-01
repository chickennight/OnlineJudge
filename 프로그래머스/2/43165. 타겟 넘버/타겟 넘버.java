class Solution {
    
    private int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0, 0, target, numbers);
        return answer;
    }
    
    private void dfs(int idx, int sum, int target, int[] numbers){        
        if(idx == numbers.length){
            if(sum == target)
                answer++;
            return;
        }
        
        dfs(idx+1, sum+numbers[idx], target, numbers);
        dfs(idx+1, sum-numbers[idx], target, numbers);
    }
}