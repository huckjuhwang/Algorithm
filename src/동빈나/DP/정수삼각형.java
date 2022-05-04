package 동빈나.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수삼각형 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <= i ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int d[][] = new int[n][n];
        d[0][0] = arr[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i ; j++) {
                int left, right;

                if (j == 0) left = 0;
                else left = d[i - 1][j - 1];

                if (j == i) right = 0;
                else right = d[i-1][j];

                d[i][j] = Math.max(left, right) + arr[i][j];
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < d[n - 1][i]) {
                max = d[n - 1][i];
            }
        }
        System.out.println(max);
    }
}
