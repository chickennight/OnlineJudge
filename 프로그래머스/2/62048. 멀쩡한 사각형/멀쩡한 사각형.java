class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        int gcd = GCD(w,h);
        int x = w/gcd;
        int y = h/gcd;
        answer = (long)w*h-(x+y-1)*gcd;
        return answer;
    }
    
    private int GCD(int a, int b){
        if(a%b==0) return b;
        return GCD(b,a%b);
    }
}