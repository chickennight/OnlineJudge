import java.util.*;
class Solution {
    static PriorityQueue<String> pq;
    static boolean[] visited;
    static String[][] ticket;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        pq = new PriorityQueue<>();
        ticket = tickets;
        dfs("ICN", 0, "ICN");
        String[] answer = pq.peek().split("/");
        return answer;
    }
    
    static void dfs(String now, int cnt, String path){
        if(cnt == ticket.length){
            pq.add(path);
            return;
        }
        for(int i=0; i<ticket.length; ++i){
            if(!visited[i] && now.equals(ticket[i][0])){
                visited[i] = true;
                dfs(ticket[i][1], cnt+1, path+"/"+ticket[i][1]);
                visited[i] = false;
            }
        }
    }
}