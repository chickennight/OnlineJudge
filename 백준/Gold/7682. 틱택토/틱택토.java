// 7682 틱택토

import java.io.*;

public class Main {

    private static final char[][] board = new char[3][3];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = in.readLine();
            if (input.equals("end")) break;

            int countO = 0, countX = 0;
            for (int i = 0; i < 9; ++i) {
                char c = input.charAt(i);
                board[i / 3][i % 3] = c;
                if (c == 'O') countO++;
                else if (c == 'X') countX++;
            }

            boolean xWin = isWinner('X');
            boolean oWin = isWinner('O');

            if (isValid(countX, countO, xWin, oWin)) {
                sb.append("valid\n");
            } else {
                sb.append("invalid\n");
            }
        }

        System.out.print(sb);
    }

    private static boolean isValid(int countX, int countO, boolean xWin, boolean oWin) {
        if (countX < countO || countX > countO + 1) return false;
        if (xWin && oWin) return false;
        if (xWin && countX != countO + 1) return false;
        if (oWin && countX != countO) return false;
        return xWin || oWin || countX + countO >= 9;
    }

    private static boolean isWinner(char player) {
        for (int i = 0; i < 3; ++i)
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;

        for (int j = 0; j < 3; ++j)
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player)
                return true;

        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }
}