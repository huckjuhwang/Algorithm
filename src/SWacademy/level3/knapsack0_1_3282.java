package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * DFS 시간초과 실패
 * DP로 풀어볼것
 */
public class knapsack0_1_3282 {

    static int arr[][];
    static int N, K;
    static int max;
    static boolean visit[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][2];
            visit = new boolean[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < N; i++) {
                visit = new boolean[N];
                visit[i] = true;
                dfs(arr[i][0], arr[i][1]);
            }

            System.out.println(max);
        }
    }

    public static void dfs(int sum, int cnt){
        //  종료 조건
        if (N < cnt) {
            return;
        }
        // 최대 가치값 삽입
        if (sum > max) {
            System.out.println(sum);
            max = sum;
        }

        for (int i = 0; i < N; i++) {
            if( !visit[i] ) {
                visit[i] = true;
                dfs(sum + arr[i][0], cnt + arr[i][1]);
            }
        }
    }
}
