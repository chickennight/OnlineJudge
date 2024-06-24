import java.util.*;

class Traffic {
    int start, end;
    
    public Traffic(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int solution(String[] lines) {
        List<Traffic> list = new ArrayList();
        
        for(int i = 0; i < lines.length; i++) {
            int end =(Integer.parseInt(lines[i].substring(11,13))*3600
            + Integer.parseInt(lines[i].substring(14,16))*60)*1000
            + (int)(Double.parseDouble(lines[i].substring(17,23))*1000);
            
            int trafficTime = (int)(Double.parseDouble(lines[i].substring(24,lines[i].length()-1))*1000);
            
            int start = end-trafficTime+1;
            list.add(new Traffic(start, end));
        }
        
        int max = 1;
        int cnt;
        for(int i = 0; i<list.size(); ++i) {
            cnt = 1;
            for(int j = i+1; j<list.size(); ++j)
                if(list.get(i).end+1000 > list.get(j).start)
                    cnt++;
            
            max = Math.max(max,cnt);
        }
        
        return max;
    }
}