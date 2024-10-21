import java.io.*;

public class Main {
    private final static int[] dx = {0, 1, 0, -1};
    private final static int[] dy = {1, 0, -1, 0};

    private static int min;
    private static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int k = 0;
        min = 8;
        while (true) {
            board = new char[5][9];
            for (int i = 0; i < 5; ++i) {
                board[i] = in.readLine().toCharArray();
            }

            int cnt = 0;
            for (char[] boardLine : board) {
                for (char x : boardLine) {
                    if (x == 'o') {
                        cnt++;
                    }
                }
            }
            min = cnt;
            dfs(min);
            System.out.println(min + " " + (cnt - min));
            k++;
            if (k == n) {
                break;
            }
            in.readLine();
        }
    }

    static void dfs(int pin) {
        if (pin < min) {
            min = pin;
        }

        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == 'o') {
                    for (int d = 0; d < 4; ++d) {
                        int nextX = i + dx[d];
                        int nextY = j + dy[d];
                        int newX = nextX + dx[d];
                        int newY = nextY + dy[d];

                        if (checkTarget(nextX, nextY, 'o') && checkTarget(newX, newY, '.')) {
                            board[i][j] = '.';
                            board[nextX][nextY] = '.';
                            board[newX][newY] = 'o';
                            dfs(pin - 1);
                            board[i][j] = 'o';
                            board[nextX][nextY] = 'o';
                            board[newX][newY] = '.';
                        }
                    }
                }
            }
        }
    }

    static boolean checkTarget(int x, int y, char target) {
        if (x < 0 || x >= 5 || y < 0 || y >= 9)
            return false;
        return board[x][y] == target;
    }
}