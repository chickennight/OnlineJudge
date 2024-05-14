import java.util.*;
class Solution {
    
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = toInt(play_time);
        int advTime = toInt(adv_time);
        
        int[] times = new int[360000];
        
        for (String log : logs) {
            String[] splitLog = log.split("-");
            int start = toInt(splitLog[0]);
            int end = toInt(splitLog[1]);
            
            for (int i=start; i<end; ++i) {
                times[i]++;
            }
        }

        int maxIdx = 0;
        long total = 0;
        for (int i = 0; i < advTime; ++i) {
            total += times[i];
        }
        long maxTime = total;
        for (int i = advTime; i < playTime; i++) {
            total += times[i] - times[i - advTime];
            if (total > maxTime) {
                maxTime = total;
                maxIdx = i - advTime + 1;
            }
        }

        return toStr(maxIdx);
    }

    private int toInt(String str) {
        int[] time = Arrays.stream(str.split(":"))
            .mapToInt(Integer::parseInt)
            .toArray();

        return 3600 * time[0] + 60 * time[1] + time[2];
    }

    private String toStr(int time) {
        int H = time / 3600;
        int M = (time - 3600 * H) / 60;
        int S = time - 3600 * H - 60 * M;

        return (H < 10 ? "0" : "") + H + ":" +
            (M < 10 ? "0" : "") + M + ":" +
            (S < 10 ? "0" : "") + S;
    }
}