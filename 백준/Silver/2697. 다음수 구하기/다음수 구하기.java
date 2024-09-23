import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        int length, i, j;
        while (T-- > 0) {
            String str = in.readLine();
            length = str.length();
            int[] cnt = new int[10];
            for (i = length - 1; i > 0; --i)
                if (str.charAt(i - 1) < str.charAt(i)) {
                    for (j = i - 1; j < length; ++j) cnt[str.charAt(j) - '0']++;
                    sb.append(str, 0, i - 1);
                    for (j = str.charAt(i - 1) - '0' + 1; j < 10; ++j) {
                        if (cnt[j] > 0) {
                            cnt[j]--;
                            sb.append(j);
                            break;
                        }
                    }
                    for (j = 0; j < 10; ++j)
                        while (cnt[j]-- > 0)
                            sb.append(j);

                    sb.append("\n");
                    break;
                }

            if (i == 0)
                sb.append("BIGGEST\n");
        }
        System.out.println(sb);
    }

}