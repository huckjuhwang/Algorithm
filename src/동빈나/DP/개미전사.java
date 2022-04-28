package 동빈나.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 첫째줄에 식량창고의 개수 N이 주어진다.
 * 둘째줄에 공백을 기준으로 각 식량창고에 저장 된 식량의 개수 K가 주어질때,
 *
 * 개미전사가 얻을 수 있는 식량 최댓값을 선택하시오
 *
 * input
 * 4
 * 1 3 1 5
 *
 * output
 * 8
 */
public class 개미전사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int numbers[] = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[100];
        dp[0] = numbers[0];
        dp[1] = Math.max(numbers[0], numbers[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(numbers[i] + dp[i - 2], dp[i - 1]);
        }

        System.out.println(dp[n-1]);
    }
}
