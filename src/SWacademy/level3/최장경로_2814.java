package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최장경로_2814 {
    public static int max;
    public static int route[][];
    public static boolean visit[];
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            max = 0;

            route = new int[N+1][N+1];
            visit = new boolean[N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());

                route[num1][num2] = 1;
                route[num2][num1] = 1;
            }

            for (int i = 1; i <= N; i++) {
                visit[i] = true;
                solve(i,  1);
                visit[i] = false;
            }
            System.out.println("#" + testCase + " " + (max));

        }
    }

    public static void solve(int idx, int count){
        if (count > max) {
            max = count;
        }

        for (int i = 1; i <= N; i++) {
            if( route[idx][i] == 1 && !visit[i]){
                visit[i] = true;
                solve(i,count+1);
                visit[i] = false;
            }
        }
    }
}
