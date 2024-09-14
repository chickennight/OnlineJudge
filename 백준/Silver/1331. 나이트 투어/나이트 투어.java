import java.io.*;

public class Main {
    ;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] map = new boolean[6][7];
        boolean tf = true;
        String input = in.readLine();
        int startX = input.charAt(0) - 'A';
        int startY = input.charAt(1) - '0';
        int nowX = startX;
        int nowY = startY;
        map[startX][startY] = true;

        for (int i = 0; i < 35; ++i) {
            input = in.readLine();
            int x = input.charAt(0) - 'A';
            int y = input.charAt(1) - '0';
            if (available(x, y, nowX, nowY)) {
                if (map[x][y]) {
                    tf = false;
                    break;
                }
                map[x][y] = true;
                nowX = x;
                nowY = y;
            } else {
                tf = false;
                break;
            }
        }

        if (tf)
            tf = available(nowX, nowY, startX, startY);

        System.out.println(tf ? "Valid" : "Invalid");

    }

    private static boolean available(int x, int y, int nx, int ny) {
        return (Math.abs(x - nx) == 2 && Math.abs(y - ny) == 1) || (Math.abs(x - nx) == 1 && Math.abs(y - ny) == 2);
    }
}