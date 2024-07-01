class Solution {
    public int[] solution(int n, long left, long right) {
        long size = right-left+1;
        int[] answer = new int[(int)size];
        for(int i=0; i<(int)size; ++i){
            answer[i] = (int)Math.max((left+i)/n,(left+i)%n)+1;
        }
        return answer;
    }
}