import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = func(m);
        int max = 0;
        for(String musicinfo: musicinfos) {
            StringBuilder sb = new StringBuilder();
            String[] str = musicinfo.split(",");
            StringTokenizer st = new StringTokenizer(str[1], ":");
            int time = Integer.parseInt(st.nextToken()) * 60;
            time += Integer.parseInt(st.nextToken());
            st = new StringTokenizer(str[0], ":");
            time -= Integer.parseInt(st.nextToken()) * 60;
            time -= Integer.parseInt(st.nextToken());
            String note = func(str[3]);
            
            for(int i=0; i<time; ++i) 
                sb.append(note.charAt(i % note.length()));
            
            if(sb.toString().contains(m)){
                if(max < sb.length()){
                    max = sb.length();
                    answer = str[2];
                }
            }
        }
        return answer;
    }
    
    String func(String note) {
        note = note.replace("A#", "a");
        note = note.replace("B#", "b");
        note = note.replace("C#", "c");
        note = note.replace("D#", "d");
        note = note.replace("F#", "f");
        note = note.replace("G#", "g");
        return note;
    }
}