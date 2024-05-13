class Solution {
    public int solution(int[] money) {
        int size = money.length;
        int[] dpYes = new int[size];
        int[] dpNo = new int[size];
        
        dpYes[0] = money[0];
        dpYes[1] = money[0];

        dpNo[0] = 0;
        dpNo[1] = money[1];
        
        for(int i=2; i<size; ++i){
            dpYes[i] = Math.max(dpYes[i-2]+money[i], dpYes[i-1]);
            dpNo[i] = Math.max(dpNo[i-2]+money[i], dpNo[i-1]);
        }

        return Math.max(dpYes[size-2], dpNo[size-1]);
    }
}