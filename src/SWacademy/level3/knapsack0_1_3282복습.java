package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class knapsack0_1_3282복습 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());       // 물건의 최대 개수
            int k = Integer.parseInt(st.nextToken());       // 넣을 수 있는 최대 부피

            int Vi[] = new int[n+1];
            int Ci[] = new int[n+1];

            int d[][] = new int[n + 1][k + 1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                Vi[i] = Integer.parseInt(st.nextToken());
                Ci[i] = Integer.parseInt(st.nextToken());
            }


            for (int i = 1; i <= n; i++) {
                // 넣을 수 있는 최대 무게
                for (int j = 1; j <= k; j++) {
                    if (Vi[i] > j) {
                        d[i][j] = d[i-1][j];
                    }else{
                        d[i][j] = Math.max(d[i-1][j], d[i - 1][j - Vi[i]] + Ci[i]);
                    }
                }
            }

            System.out.println(d[n][k]);
        }
    }
}
