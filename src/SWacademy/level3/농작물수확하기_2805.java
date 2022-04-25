package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 농작물수확하기_2805 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[n][n];
            int sum = 0;

            // input
            for (int i = 0; i < n; i++) {
                String nums = br.readLine();

                for (int j = 0; j < n; j++) {
                    arr[i][j] = nums.charAt(j) - '0';
                    sum += arr[i][j];
                }
            }

            int calc = n / 2;
            int minus = 0;

            // 좌측 상단
            for (int i = 0; i < calc; i++) {
                for (int j = 0; j < calc-i; j++) {
                    minus += arr[i][j];
                    minus += arr[i][n-j-1];
                    minus += arr[n-i-1][j];
                    minus += arr[n-i-1][n-j-1];
                }
            }

            System.out.println("#" + testCase + " " + (sum-minus));
        }
    }
}
