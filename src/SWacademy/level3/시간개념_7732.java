package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시간개념_7732 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ":");
            int nHour = Integer.parseInt(st.nextToken());
            int nMinute = Integer.parseInt(st.nextToken());
            int nSecond = Integer.parseInt(st.nextToken());

            int allHour = 0;
            int allMinute = 0;

            st = new StringTokenizer(br.readLine(), ":");
            int pHour = Integer.parseInt(st.nextToken());
            int pMinute = Integer.parseInt(st.nextToken());
            int pSecond = Integer.parseInt(st.nextToken());


            int rHour = 0;
            int rMinute = 0;
            int rSecond = 0;


            rSecond = pSecond - nSecond;
            if (rSecond < 0) {
                rSecond += 60;
                allMinute++;    // 분에서 하나 빌림
            }
            rMinute = pMinute - nMinute - allMinute;
            if (rMinute < 0) {
                rMinute += 60;
                allHour++;      // 시에서 하나빌림
            }
            rHour = pHour - nHour - allHour;
            if (rHour < 0) {
                rHour += 24;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(testCase).append(" ");
            sb.append((rHour == 0)? "00" : (rHour < 10) ? "0" + rHour : rHour).append(":")
                    .append(rMinute == 0? "00" :(rMinute < 10) ? "0" + rMinute : rMinute).append(":")
                    .append(rSecond == 0? "00" :(rSecond < 10) ? "0" + rSecond : rSecond);

            System.out.println(sb);
        }
    }
}
