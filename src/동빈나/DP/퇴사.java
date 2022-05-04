package 동빈나.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int t[] = new int[n+1];
        int p[] = new int[n+1];
        int dp[] = new int[n+1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            int time = t[i] + i;
            if (time > n) {
                dp[i] = max;
            }else{
                dp[i] = Math.max(p[i] + dp[time], max);
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}
