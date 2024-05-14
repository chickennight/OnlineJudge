import java.util.*;
class Solution {
    
    static HashMap<Long, Long> map = new HashMap<>();

    static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        
        for (int i = 0; i < room_number.length; ++i)
            answer[i] = findEmptyRoom(room_number[i]);
        
        return answer;
    }

    static Long findEmptyRoom(long num) {
        if (!map.containsKey(num)) {
            map.put(num, num + 1);
            return num;
        }
        long empty = findEmptyRoom(map.get(num));
        map.put(num, empty);
        return empty;
    }
}