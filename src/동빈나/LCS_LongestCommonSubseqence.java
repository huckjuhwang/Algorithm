package 동빈나;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최장 공통 부분수열 구하는 로직 이며,
 *
 * 역으로 추적하는 로직도 같이 가지고 있음.
 */
public class LCS_LongestCommonSubseqence {
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
                    else{
                        dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    }
                }
            }


            System.out.println(dp[str1.length()][str2.length()]);


            int n = str1.length();
            int m = str2.length();

            StringBuilder sb = new StringBuilder();

            while (n != 0 && m != 0) {
                // 왼쪽, 위쪽의 값이 같다면,
                if (dp[n - 1][m] == dp[n][m - 1]) {
                    sb.insert(0, str1.charAt(n-1));
                    n--;
                    m--;
                }
                // 같지 않다면 좌우중 큰 값으로 이동
                else{
                    // 위쪽이 더 크다면
                    if (dp[n - 1][m] > dp[n][m - 1]) {
                        n--;
                    }else{
                        m--;
                    }
                }
            }

            System.out.println(sb);

        }

    }
}

