import java.util.*;
import java.io.*;

public class Main {

    static class Team implements Comparable<Team> {
        int maxHeight;
        int members;

        public Team(int maxHeight, int members) {
            this.maxHeight = maxHeight;
            this.members = members;
        }

        @Override
        public int compareTo(Team o) {
            if (members != o.members) {
                return members - o.members;
            }
            return maxHeight - o.maxHeight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        Map<Integer, Integer> studentInfo = new TreeMap<>(Collections.reverseOrder());
        TreeSet<Team> teams = new TreeSet<>();

        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(in.readLine());
            int height = Integer.parseInt(st.nextToken());
            int maxLonger = Integer.parseInt(st.nextToken());
            studentInfo.put(height, maxLonger);
        }

        for (int height : studentInfo.keySet()) {
            if (teams.isEmpty()) {
                teams.add(new Team(height, 1));
                continue;
            }

            Team lowTeam = teams.lower(new Team(height, studentInfo.get(height)));
            if (lowTeam == null) {
                teams.add(new Team(height, 1));
                continue;
            }

            lowTeam.members++;
        }

        System.out.println(teams.size());
    }
}