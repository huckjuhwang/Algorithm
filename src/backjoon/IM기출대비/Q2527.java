package backjoon.IM기출대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2527 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            Point a = new Point(x, y, p, q);

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());
            Point b = new Point(x, y, p, q);


            // 점인 경우
            if ((a.x == b.p && a.y == b.q) ||
                    (a.q == b.x && a.p == b.y) ||
                    (a.p == b.x && a.y == b.q) ||
                    (a.x == b.p && a.q == b.y)) {
                System.out.println("c");
            }else if ((a.p == b.x && a.q != b.y) ||
                        (a.q == b.y && a.p != b.x) ||
                        (a.x == b.p && a.y != b.q) ||
                        (a.y == b.q && a.x != b.p)) {
                    System.out.println("b");
            } else if (a.p < b.x ||
                    a.q < b.y ||
                    b.p < a.x ||
                    b.q < a.y) {

                System.out.println("d");
            } else {
                System.out.println("a");
            }
            // 나머지 (3)

        }
    }

}

class Point{
    public int x;
    public int y;
    public int p;
    public int q;

    public Point(int x, int y, int p, int q) {
        this.x = x;
        this.y = y;
        this.p = p;
        this.q = q;
    }
}
