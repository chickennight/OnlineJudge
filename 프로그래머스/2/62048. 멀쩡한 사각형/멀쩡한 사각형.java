// 멀쩡한 사각형
class Solution {
    public long solution(int w, int h) {
        return (long)w*h+GCD(w,h)-w-h;
    }
    
    private int GCD(int a, int b){
        if(a%b==0) return b;
        return GCD(b,a%b);
    }
}