import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        int size = ranges.length;
        
        int idx = 0;
        int prev = k;
        List<Double> record = new ArrayList<>();
        record.add(0.0d);
        
        double area;
        while(k > 1){
            if(k%2 == 0)
                k = k/2;
            else
                k = k*3+1;
            
            record.add(((double)prev+k)/2);
            prev = k;
        }
        
        int n = record.size()-1;
        
        double[] answer = new double[size];
        int start,end;
        for(int i=0; i<size; ++i){
            start = ranges[i][0];
            end = n+ranges[i][1];
            if(start>end)
                answer[i] = -1.0;
            else{
                for(int j=start+1; j<=end; ++j){
                    answer[i]+=record.get(j);
                }
            }
        }
        return answer;
    }
}