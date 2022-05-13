package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 현주의상자바꾸기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int result[] = new int[n + 1];

            for (int i = 1; i <= q; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int L = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());

                for (int j = L; j <= R; j++) {
                    result[j] = i;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(testCase).append(" ");
            for (int i = 1; i < result.length; i++) {
                sb.append(result[i]).append(" ");
            }
            System.out.println(sb);
        }
    }
}
