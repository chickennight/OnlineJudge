import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] bookTime = new int[book_time.length][2];
        
        for(int i = 0; i<book_time.length; ++i){
            int start = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end = Integer.parseInt(book_time[i][1].replace(":", ""));
            
            end += 10;
            
            if(end % 100 >= 60)
                end += 40;
            
            bookTime[i][0] = start;
            bookTime[i][1] = end;
            
        }
        
        Arrays.sort(bookTime, (o1, o2) -> o1[0] - o2[0] );
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for(int[] book : bookTime){
            
            if(pq.isEmpty()){
                pq.add(book);
            }else{
                int[] top = pq.peek();
                int start = top[0];
                int end = top[1];
                
                if(book[0] >= end)
                    pq.poll();
                
                pq.add(book);
            }
            
        }

        return pq.size();
    }
}