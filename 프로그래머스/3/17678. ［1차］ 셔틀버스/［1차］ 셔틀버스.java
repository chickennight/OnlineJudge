import java.util.*;
 
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(String table: timetable){
            int time = Integer.parseInt(table.substring(0,2))*60 + Integer.parseInt(table.substring(3,5));
            pq.add(time);
        }
     
        int start = 9*60;
        int last = 0;
        int total = 0;
        for(int i=0; i<n; ++i){
            total = 0;    
            while(!pq.isEmpty()){
                int now = pq.peek();
                if(now<=start && total<m) {
                    pq.poll();
                    total++;
                } else 
                    break;
                last = now-1;
            }
            start += t;
        }
        if(total < m) last = start-t;
        
        String hour = String.valueOf(last/60);
        String minute = String.valueOf(last%60);
        return (hour.length()==2?hour:"0"+hour) + ":" + (minute.length()==2?minute:"0"+minute);
    }
}
