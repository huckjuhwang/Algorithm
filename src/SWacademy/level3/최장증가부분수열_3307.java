package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최장증가부분수열_3307 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {

            // 문자 개수
            int n = Integer.parseInt(br.readLine());
            // 문자 담은 배열
            int number[] = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < n; i++) {
                number[i] = Integer.parseInt(st.nextToken());
            }


            int max = 0;

            int dp[] = new int[n];

            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if( number[i] > number[j] )
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            for (int i = 0; i < dp.length; i++) {
                max = Math.max(max, dp[i]);
            }

            System.out.println("#" + testCase + " " +max);
        }

    }
}
