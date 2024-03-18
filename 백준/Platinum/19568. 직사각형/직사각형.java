import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                if (i == 15 && j < 15) {
                    System.out.print("1 ");
                } else if (i == 15 && j > 15) {
                    System.out.print("15 ");
                } else if (j == 15 && i < 15) {
                    System.out.print("225 ");
                } else if (j == 15 && i > 15) {
                    System.out.print("3375 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}