import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static char[][] U;
    static char[][] D;
    static char[][] F;
    static char[][] B;
    static char[][] L;
    static char[][] R;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        U = new char[3][3];
        D = new char[3][3];
        F = new char[3][3];
        B = new char[3][3];
        L = new char[3][3];
        R = new char[3][3];

        while (T-- > 0) {
            reset();
            int n = Integer.parseInt(in.readLine());
            StringTokenizer st = new StringTokenizer(in.readLine());
            while (n-- > 0) {
                String order = st.nextToken();
                char place = order.charAt(0);
                char dir = order.charAt(1);

                move(place, dir);
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(U[i][j]);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    static void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                U[i][j] = 'w';
                D[i][j] = 'y';
                F[i][j] = 'r';
                B[i][j] = 'o';
                L[i][j] = 'g';
                R[i][j] = 'b';
            }
        }
    }

    static void move(char place, char dir) {
        switch (place) {
            case 'U':
                turnU(dir);
                break;
            case 'D':
                turnD(dir);
                break;
            case 'F':
                turnF(dir);
                break;
            case 'B':
                turnB(dir);
                break;
            case 'L':
                turnL(dir);
                break;
            case 'R':
                turnR(dir);
                break;
        }
    }

    public static void turnU(char dir) {
        U = rotate(U, dir);
        if (dir == '+') {
            char[] temp = B[0];
            B[0] = L[0];
            L[0] = F[0];
            F[0] = R[0];
            R[0] = temp;
        } else {
            char[] temp = B[0];
            B[0] = R[0];
            R[0] = F[0];
            F[0] = L[0];
            L[0] = temp;
        }
    }

    public static void turnD(char dir) {
        D = rotate(D, dir);
        if (dir == '+') {
            char[] temp = B[2];
            B[2] = R[2];
            R[2] = F[2];
            F[2] = L[2];
            L[2] = temp;
        } else {
            char[] temp = B[2];
            B[2] = L[2];
            L[2] = F[2];
            F[2] = R[2];
            R[2] = temp;
        }
    }

    public static void turnF(char dir) {
        F = rotate(F, dir);
        if (dir == '+') {
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) {
                temp[i] = U[2][i];
            }
            for (int i = 0; i < 3; i++) {
                U[2][i] = L[2 - i][2];
            }
            for (int i = 0; i < 3; i++) {
                L[i][2] = D[2][2 - i];
            }
            for (int i = 0; i < 3; i++) {
                D[2][i] = R[i][0];
            }
            for (int i = 0; i < 3; i++) {
                R[i][0] = temp[i];
            }
        } else {
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) {
                temp[i] = U[2][2 - i];
            }
            for (int i = 0; i < 3; i++) {
                U[2][i] = R[i][0];
            }
            for (int i = 0; i < 3; i++) {
                R[i][0] = D[2][i];
            }
            for (int i = 0; i < 3; i++) {
                D[2][i] = L[2 - i][2];
            }
            for (int i = 0; i < 3; i++) {
                L[i][2] = temp[i];
            }
        }
    }

    public static void turnB(char dir) {
        B = rotate(B, dir);
        if (dir == '+') {
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) {
                temp[i] = U[0][2 - i];
            }
            for (int i = 0; i < 3; i++) {
                U[0][i] = R[i][2];
            }
            for (int i = 0; i < 3; i++) {
                R[i][2] = D[0][i];
            }
            for (int i = 0; i < 3; i++) {
                D[0][i] = L[2 - i][0];
            }
            for (int i = 0; i < 3; i++) {
                L[i][0] = temp[i];
            }
        } else {
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) {
                temp[i] = U[0][i];
            }
            for (int i = 0; i < 3; i++) {
                U[0][i] = L[2 - i][0];
            }
            for (int i = 0; i < 3; i++) {
                L[i][0] = D[0][2 - i];
            }
            for (int i = 0; i < 3; i++) {
                D[0][i] = R[i][2];
            }
            for (int i = 0; i < 3; i++) {
                R[i][2] = temp[i];
            }
        }
    }

    public static void turnL(char dir) {
        L = rotate(L, dir);
        if (dir == '+') {
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) {
                temp[i] = U[i][0];
            }
            for (int i = 0; i < 3; i++) {
                U[i][0] = B[2 - i][2];
            }
            for (int i = 0; i < 3; i++) {
                B[i][2] = D[i][2];
            }
            for (int i = 0; i < 3; i++) {
                D[i][2] = F[2 - i][0];
            }
            for (int i = 0; i < 3; i++) {
                F[i][0] = temp[i];
            }
        } else {
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) {
                temp[i] = U[2 - i][0];
            }
            for (int i = 0; i < 3; i++) {
                U[i][0] = F[i][0];
            }
            for (int i = 0; i < 3; i++) {
                F[i][0] = D[2 - i][2];
            }
            for (int i = 0; i < 3; i++) {
                D[i][2] = B[i][2];
            }
            for (int i = 0; i < 3; i++) {
                B[i][2] = temp[i];
            }
        }
    }

    public static void turnR(char dir) {
        R = rotate(R, dir);
        if (dir == '+') {
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) {
                temp[i] = U[2 - i][2];
            }
            for (int i = 0; i < 3; i++) {
                U[i][2] = F[i][2];
            }
            for (int i = 0; i < 3; i++) {
                F[i][2] = D[2 - i][0];
            }
            for (int i = 0; i < 3; i++) {
                D[i][0] = B[i][0];
            }
            for (int i = 0; i < 3; i++) {
                B[i][0] = temp[i];
            }
        } else {
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) {
                temp[i] = U[i][2];
            }
            for (int i = 0; i < 3; i++) {
                U[i][2] = B[2 - i][0];
            }
            for (int i = 0; i < 3; i++) {
                B[i][0] = D[i][0];
            }
            for (int i = 0; i < 3; i++) {
                D[i][0] = F[2 - i][2];
            }
            for (int i = 0; i < 3; i++) {
                F[i][2] = temp[i];
            }
        }
    }

    public static char[][] rotate(char[][] arr, char dir) {
        char[][] rotate = new char[3][3];

        if (dir == '+') {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    rotate[i][j] = arr[3 - 1 - j][i];
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    rotate[i][j] = arr[j][3 - 1 - i];
                }
            }
        }

        return rotate;
    }
}