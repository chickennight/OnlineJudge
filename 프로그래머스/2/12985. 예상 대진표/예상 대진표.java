class Solution{
    public int solution(int n, int a, int b){
        int answer = 1;
        
        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }

        while(true){
            if(b-a==1 && a/2==b/2-1) break;
            a = a/2 + (a%2==0?0:1);
            b = b/2 + (b%2==0?0:1);
            answer++;
        }

        return answer;
    }
}