import java.util.*;
import java.io.*;

public class Main {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static HashMap<Character, int[]> block;
    private static char[][] map;
    private static int R, C;

    public static void main(String[] args) throws Exception {
        blockInit();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String rc = in.readLine();
        R = Integer.parseInt(rc.split(" ")[0]);
        C = Integer.parseInt(rc.split(" ")[1]);
        map = new char[R][C];
        for (int i = 0; i < R; ++i)
            map[i] = in.readLine().toCharArray();

        System.out.println(searchBreakPoint());
    }

    private static void blockInit() {
        block = new HashMap<>();
        block.put('|', new int[]{0, 2});
        block.put('-', new int[]{1, 3});
        block.put('+', new int[]{0, 1, 2, 3});
        block.put('1', new int[]{1, 2});
        block.put('2', new int[]{0, 1});
        block.put('3', new int[]{0, 3});
        block.put('4', new int[]{2, 3});
    }

    private static String searchBreakPoint() {
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if (map[i][j] == '.') {
                    int[] path = findPath(i, j);
                    if (path.length == 0) continue;
                    return (i + 1) + " " + (j + 1) + " " + findBlock(path);
                }
            }
        }
        return null;
    }

    private static int[] findPath(int i, int j) {
        List<Integer> path = new ArrayList<>();
        for (int d = 0; d < dx.length; ++d) {
            int nx = i + dx[d];
            int ny = j + dy[d];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if (map[nx][ny] == '.' || map[nx][ny] == 'M' || map[nx][ny] == 'Z') continue;
            int[] shape = block.get(map[nx][ny]);
            for (int n : shape) {
                if ((n + 2) % 4 == d)
                    path.add(d);
            }
        }
        int[] answer = new int[path.size()];
        for (int idx = 0; idx < answer.length; ++idx)
            answer[idx] = path.get(idx);
        return answer;
    }


    private static String findBlock(int[] path) {
        for (char key : block.keySet()) {

            int[] root = block.get(key);

            if (root.length != path.length) continue;
            boolean tf = true;
            for (int i = 0; i < path.length; ++i) {
                if (root[i] != path[i]) {
                    tf = false;
                    break;
                }
            }
            if (tf) {
                return String.valueOf(key);
            }
        }
        return null;
    }

}