import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(in.readLine());
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < S; ++i) {
            String input = in.readLine().toLowerCase().trim().replaceAll(" ", "");
            for (int j = 0; j < input.length(); ++j) {
                if (input.charAt(j) == 'a' || input.charAt(j) == 'e' || input.charAt(j) == 'i' || input.charAt(j) == 'o' || input.charAt(j) == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }

            }
            if (vowels != 0 && consonants != 0) {
                System.out.println(consonants + " " + vowels);
                vowels = 0;
                consonants = 0;
            }
        }

    }
}