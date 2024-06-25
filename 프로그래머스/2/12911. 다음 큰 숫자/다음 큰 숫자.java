class Solution {
    public int solution(int n) {        
        int now = Integer.bitCount(n);

        while(true){
            n++;
            int next = Integer.bitCount(n);

            if(now == next)
                break;
        }

        return n;
    }
}