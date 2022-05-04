package 동빈나.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//2
//3 4
//1 3 3 2 2 1 4 1 0 6 4 7
public class 금광 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int arr[][] = new int[n][m];
            int d[][] = new int[n][m];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (j == 0) {
                        d[i][j] = arr[i][j];
                    }
                }
            }


            for (int j = 1; j < m; j++) {
                for (int i = 0; i < n; i++) {
                  int leftUp, leftDown, left;

                    if (i == 0) leftUp = 0;
                    else leftUp = d[i - 1][j - 1];

                    if (i == n - 1) leftDown = 0;
                    else leftDown = d[i + 1][j - 1];

                    left = d[i][j - 1];

                    d[i][j] = Math.max(leftUp, Math.max(left, leftDown)) + arr[i][j];
                }
            }

            int max = 0;
            for (int i = 0; i < n; i++) {
                if (max < d[i][m - 1]) {
                    max = d[i][m-1];
                }
            }

            System.out.println(max);
        }
    }
}
