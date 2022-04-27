package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 상원이의연속합 {

    public static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 1; i <= n; i++) {
                dfs(n, 0, i);
            }

            System.out.println("#" + testCase + " " + cnt);
            cnt = 0;
        }
    }

    public static void dfs(int n, int sum, int start) {
        if (sum > n) {
            return;
        }
        // 합계가 N과 같다면 count값 저장
        if (sum == n) {
            cnt++;
        }
        dfs(n, sum+start, start+1);
    }
}
