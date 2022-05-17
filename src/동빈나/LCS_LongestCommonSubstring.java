package 동빈나;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LCS_LongestCommonSubstring {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            int n = str1.length();
            int m = str2.length();
            int dp[][] = new int[n+1][m+1];

            int max = 0;
            int x =0, y = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 같다면 왼쪽 대각위 +1
                    if (str1.charAt(i) == str2.charAt(j)) {
                        dp[i+1][j+1] = dp[i][j] + 1;
                        if (max < dp[i + 1][j + 1]) {
                            max = dp[i + 1][j + 1];
                            x = i;
                            y = j;
                        }
                    }else{
                        dp[i + 1][j + 1] = 0;
                    }
                }
            }
            System.out.println("#" + testCase + " " + dp[x+1][y+1]);


            // 결과 출력 로직
            n = x+1;
            m = y+1;
            StringBuilder sb = new StringBuilder();

            while (dp[n][m] != 0) {
                sb.insert(0, dp[n--][m--]);
            }
            System.out.println(sb);
        }
    }
}
