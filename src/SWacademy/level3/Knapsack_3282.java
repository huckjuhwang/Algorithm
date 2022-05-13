package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Knapsack_3282 {

    static int n, k;
    static int max_ci;
    static boolean visit[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());   // 물건의 최대개수
            k = Integer.parseInt(st.nextToken());   // 물건의 최대 부피
            max_ci = 0;
            visit = new boolean[n];

            // 부피, 가치
            int arr[][] = new int[n][2];
            for (int i = 0; i < n; i++) {

                st = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                visit[i] = true;
                dfs(arr, arr[i][0], arr[i][1], 1);
                visit[i] = false;
            }
            System.out.println("#" + testCase + " " + max_ci);
        }
    }

    public static void dfs(int arr[][], int vi, int ci, int count){
        // 부피가 K를 초과했을 경우 return
        if (vi > k) {
            return;
        }
        max_ci = Math.max(max_ci, ci);

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(arr, vi + arr[i][0], ci + arr[i][1], count + 1);
                visit[i] = false;
            }
        }
    }
}
