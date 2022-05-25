package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17180 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String A = br.readLine();
        String B = br.readLine();
        long dp[][] = new long[301][301];

        for (int i = 1; i <= n; i++)
            dp[i][1] = dp[i-1][1] + Math.abs(A.charAt(i-1) - B.charAt(0));


        for (int i = 1; i <= m; i++)
            dp[1][i] = dp[1][i-1] + Math.abs(A.charAt(0) - B.charAt(i-1));


        for (int i = 2; i <= n; i++){
            for (int j = 2; j <= m; j++) {

                char chA = A.charAt(i - 1);
                char chB = B.charAt(j - 1);
                // 두개의 문자가 같다면
                if (chA == chB) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1],dp[i - 1][j]));
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1],dp[i - 1][j])) + Math.abs(chA - chB);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
