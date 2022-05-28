package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가랏RC카_1940_복습 {

    static int plus = 1;
    static int minus = 2;
    static int stay = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int speed = 0;  // 음수는 안됨
            int distance = 0 ;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int state = Integer.parseInt(st.nextToken());

                if (state == stay) {
                    distance += speed;
                    continue;
                }

                int ms = Integer.parseInt(st.nextToken());
                if (state == plus) {
                    speed += ms;
                } else if (state == minus) {
                    speed -= (speed - ms < 0) ? 0 : ms;
                }
                distance += speed;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(testCase);
            sb.append(" ").append(distance);

            System.out.println(sb);
        }

    }
}
