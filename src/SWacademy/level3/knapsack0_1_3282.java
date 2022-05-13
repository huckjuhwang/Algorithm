package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Scanner;
/**
 * DFS 시간초과 실패
 * DP로 풀어볼것
 */
public class knapsack0_1_3282 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());   // 물건의 최대개수
            int k = Integer.parseInt(st.nextToken());   // 물건의 최대 부피
            int max_ci = 0;

            // 부피, 가치
            int v[] = new int[n+1];
            int c[] = new int[n+1];
            int d[][] = new int[n + 1][k + 1];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                v[i] = Integer.parseInt(st.nextToken());
                c[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    if (v[i] > j) { // 현재 부피(j)에 넣을 무게(v[i])가 들어갈수 없다면,
                        d[i][j] = d[i - 1][j];
                    }else{
                        d[i][j] = Math.max(d[i - 1][j - v[i]] + c[i], d[i - 1][j]);
                    }
                }
            }

            System.out.println("#" + testCase + " " + d[n][k]);

        }
    }

}