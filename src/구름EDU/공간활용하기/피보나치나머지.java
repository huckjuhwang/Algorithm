package 구름EDU.공간활용하기;

import java.io.*;
import java.lang.*;
import java.util.*;


public class 피보나치나머지 {
    static long dp[] = new long[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i < dp.length; i++)
            dp[i] = (dp[i - 2] + dp[i - 1]) % 100000000;

        int n = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < n; testCase++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num]);
        }
    }
}
