package backjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < t; testCase++) {
            int n = Integer.parseInt(br.readLine());

            long dp[] = new long[n + 4];
            dp[1] = 1; dp[2] = 1; dp[3] = 1; dp[4] = 2;

            for (int i = 5; i <= n; i++) {
                dp[i] = dp[i - 5] + dp[i - 1];
            }

            System.out.println(dp[n]);
        }
    }
}
