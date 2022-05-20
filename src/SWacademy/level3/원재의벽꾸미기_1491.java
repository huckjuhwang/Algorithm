package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 원재의벽꾸미기_1491 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Integer.parseInt(st.nextToken());
            long A = Integer.parseInt(st.nextToken());
            long B = Integer.parseInt(st.nextToken());
            long min = Long.MAX_VALUE;

            for (long R = 1; R <= N; R++) {
                for (long C = 1; C <= N; C++) {
                    if (R * C > N) break;

                    long val = A * Math.abs(R - C) + B * (N - R * C);
                    if( min > val ) min = val;
                }
            }

            System.out.println("#" + testCase + " " + min);

        }
    }
}
