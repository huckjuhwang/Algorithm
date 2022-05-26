package backjoon.분리집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9938_재풀이 {
    static int dp[];
    static boolean check[];

    public static void union(int a, int b) {
        dp[find(a)] = find(b);
    }

    public static int find(int a) {
        if (dp[a] == a) {
            return a;
        }
        return dp[a] = find(dp[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        dp = new int[l + 1];
        check = new boolean[l + 1];

        for (int i = 1; i <= l; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            String result = "LADICA";

            if (!check[a]) {
                check[a] = true;
                union(a, b);
            } else if (!check[b]) {
                check[b] = true;
                union(b, a);
            } else if (!check[find(a)]) {
                check[find(a)] = true;
                union(a, b);
            } else if (!check[find(b)]) {
                check[find(b)] = true;
                union(b, a);
            }else{
                result = "SMECE";
            }

            System.out.println(result);
        }
    }
}
