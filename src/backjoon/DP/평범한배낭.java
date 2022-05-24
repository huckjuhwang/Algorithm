package backjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int Wi[] = new int[N+1];
        int Vi[] = new int[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Wi[i] = Integer.parseInt(st.nextToken());
            Vi[i] = Integer.parseInt(st.nextToken());
        }

        int d[][] = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j >= Wi[i]) {
                    d[i][j] = Math.max(d[i-1][j], d[i - 1][j - Wi[i]] + Vi[i]);
                }else {
                    d[i][j] = d[i - 1][j];
                }
            }
        }

        System.out.println(d[N][K]);
    }
}
