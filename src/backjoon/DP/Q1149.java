package backjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1149 {

    final static int RED = 0;
    final static int GREEN = 1;
    final static int BLUE = 2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int RGB[][] = new int[n][3];
        int dp[][] = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            RGB[i][RED] = Integer.parseInt(st.nextToken());
            RGB[i][GREEN] = Integer.parseInt(st.nextToken());
            RGB[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        dp[0][RED] = RGB[0][RED];
        dp[0][GREEN] = RGB[0][GREEN];
        dp[0][BLUE] = RGB[0][BLUE];


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == RED) {
                    dp[i][j] = RGB[i][j] + Math.min(dp[i - 1][GREEN], dp[i - 1][BLUE]);
                } else if (j == BLUE) {
                    dp[i][j] = RGB[i][j] + Math.min(dp[i - 1][GREEN], dp[i - 1][RED]);
                } else if (j == GREEN){
                    dp[i][j] = RGB[i][j] + Math.min(dp[i - 1][RED], dp[i - 1][BLUE]);
                }
            }
        }

        int min = Math.min(dp[n - 1][RED], Math.min(dp[n - 1][GREEN], dp[n - 1][BLUE]));
        System.out.println(min);

    }
}
