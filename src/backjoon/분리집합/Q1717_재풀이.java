package backjoon.분리집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1717_재풀이 {

    static int dp[];
    static boolean check[];

    public static void union(int a, int b) {
        dp[find(a)] = find(b);
    }

    public static int find(int x) {
        if (dp[x] == x) {
            return x;
        }
        return dp[x] = find(dp[x]);
    }

    public static boolean check(int a, int b) {
        return find(a) == find(b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int state = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 부모의 값을 넣어줌
            if (state == 0) {
                union(a, b);
            } else if (state == 1) {
                // check
                if (check(a, b)) {
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }

    }
}
