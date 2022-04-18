package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시각덧셈_1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sh = Integer.parseInt(st.nextToken());
            int sm = Integer.parseInt(st.nextToken());
            int eh = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());

            int start_m = (sh*60) + sm;
            int end_m = (eh * 60) + em;

            int m = end_m + start_m;

            System.out.println((m / 60) );

            int hour = (((m / 60) > 12) ? (m / 60)%12 :(m / 60));

            if (hour == 0) {
                hour = 12;
            }


            System.out.println("#" + testCase + " " + hour + " " + m % 60);
        }
    }
}
