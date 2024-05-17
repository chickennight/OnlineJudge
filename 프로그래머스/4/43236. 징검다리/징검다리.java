import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int[] record = new int[rocks.length + 1];
        record[0] = rocks[0];
        record[rocks.length] = distance - rocks[rocks.length - 1];
        for(int i = 1; i < rocks.length; ++i) 
            record[i] = rocks[i] - rocks[i - 1];
        
        int answer = 0;
        int max = distance;
        int min = 1;
        while(min <= max) {
            int mid = (min + max) / 2;
            int sum = 0;
            int deleted = 0;
            for(int i = 0; i < record.length; ++i) {
                sum += record[i];
                if(sum < mid) {
                    deleted++;
                    continue;
                }
                sum = 0;
            }
            if(deleted > n) {
                max = mid - 1;
                continue;
            } 
            min = mid + 1;
            answer = Math.max(answer, mid);
        }
        return answer;
    }
}