package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최장공통부분수열_3304 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();


            int dp[][] = new int[str1.length() + 1][str2.length() + 1];

            for (int i = 0; i < str1.length(); i++) {
                for (int j = 0; j < str2.length(); j++) {
                    // 같다면
                    if (str1.charAt(i) == str2.charAt(j)) {
                        dp[i + 1][j + 1] = dp[i][j] + 1;
                    }

                    // 다르다면
                    else {
                        dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    }
                }
            }
            System.out.println("#" + testCase + " " + dp[str1.length()][str2.length()]);
        }
    }
}
