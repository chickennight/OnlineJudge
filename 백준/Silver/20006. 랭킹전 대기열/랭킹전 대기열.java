import java.io.*;
import java.util.*;

public class Main {

    public static class Room {
        int level;
        int count;
        ArrayList<Player> players = new ArrayList<>();  // 참가자 목록

        Room(int level, Player player) {
            this.level = level;
            this.players.add(player);
            this.count = 1;
        }
    }

    public static class Player implements Comparable<Player> {
        int level;
        String name;

        Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player p) {
            return (this.name).compareTo(p.name);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Deque<Room> deq = new ArrayDeque<>();

        for (int i = 0; i < p; ++i) {
            st = new StringTokenizer(in.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            boolean check = false;
            for (Room room : deq) {
                if (Math.abs(level - room.level) <= 10 & room.count < m) {
                    room.players.add(new Player(level, name));
                    room.count += 1;
                    check = true;
                    break;
                }
            }
            if (!check) {
                deq.addLast(new Room(level, new Player(level, name)));

            }
        }

        for (Room room : deq) {
            if (room.count == m) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }
            Collections.sort(room.players);
            for (int i = 0; i < room.players.size(); ++i) {
                System.out.printf("%d %s\n", room.players.get(i).level, room.players.get(i).name);
            }
        }
    }
}