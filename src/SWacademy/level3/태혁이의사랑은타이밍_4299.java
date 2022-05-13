package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 태혁이의사랑은타이밍_4299 {

    static int meet_time = 11;
    static int hour = 60;
    static int day = 24;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int D = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int time = 0;

            if (M >= meet_time) {
                time += M - meet_time;
            }else{
                time += (M - meet_time) + hour;
                H--;
            }

            if (H >= 11) {
                time += (H - meet_time) * hour;
            }else{
                time += (H - meet_time + day) * hour;
                D--;
            }

            StringBuilder sb = new StringBuilder();
            if (D-meet_time < 0) {
                sb.append(-1);
            }else{
                time += (D - meet_time) * day * hour;
                sb.append(time);
            }

            System.out.println("#" + testCase + " " + sb );
        }

    }
}
