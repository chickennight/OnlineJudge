class Solution {
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; sb.length() < t*m; ++i) sb.append(Integer.toString(i, n));
        
        char[] arr = sb.toString().toCharArray();
        StringBuilder answer = new StringBuilder();
        for (int i = p-1; i < t*m; i+=m) answer.append(arr[i]);
        
        return answer.toString().toUpperCase();
    }
}