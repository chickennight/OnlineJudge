import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(isValidDateAndTime(x, y)).append('\n');
        }

        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }

    private static String isValidDateAndTime(int x, int y) {
        StringBuilder sb = new StringBuilder();
        if (isValidTime(x, y)) {
            sb.append("Yes");
        } else {
            sb.append("No");
        }

        sb.append(" ");

        if (isValidDate(x, y)) {
            sb.append("Yes");
        } else {
            sb.append("No");
        }
        return sb.toString();
    }

    private static boolean isValidTime(int x, int y) {
        return (x < 24 && x >= 0) && (y < 60 && y >= 0);
    }

    private static boolean isValidDate(int x, int y) {
        boolean isValidDate = false;
        switch (x) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (y > 0 && y <= 31) {
                    isValidDate = true;
                }
                break;
            case 2:
                if (y > 0 && y <= 29) {
                    isValidDate = true;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (y > 0 && y <= 30) {
                    isValidDate = true;
                }
                break;
            default:
                break;
        }
        return isValidDate;
    }

}