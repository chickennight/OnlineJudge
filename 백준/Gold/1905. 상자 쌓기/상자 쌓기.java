import java.util.*;
import java.io.*;

public class Main {
    static class Box {
        int px, py, lx, ly, h;

        public Box(int px, int py, int lx, int ly, int h) {
            this.px = px;
            this.py = py;
            this.lx = lx;
            this.ly = ly;
            this.h = h;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int Lx = Integer.parseInt(st.nextToken());
        int Ly = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<Box> boxes = new ArrayList<>();
        int lx, ly, lz, px, py;
        while (N-- > 0) {
            st = new StringTokenizer(in.readLine());
            lx = Integer.parseInt(st.nextToken());
            ly = Integer.parseInt(st.nextToken());
            lz = Integer.parseInt(st.nextToken());
            px = Integer.parseInt(st.nextToken());
            py = Integer.parseInt(st.nextToken());

            int h = 0;
            for (Box b : boxes) {
                int l = b.px, r = b.px + b.lx, d = b.py, u = b.py + b.ly;
                if (r <= px || px + lx <= l) continue;
                if (u <= py || py + ly <= d) continue;
                h = Math.max(h, b.h);
            }

            boxes.add(new Box(px, py, lx, ly, h + lz));
        }

        int ans = 0;
        for (Box b : boxes) {
            ans = Math.max(ans, b.h);
        }

        System.out.println(ans);
    }
}