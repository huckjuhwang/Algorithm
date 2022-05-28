package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파리퇴치_2001_복습 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int arr[][] = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            for (int i = 0; i < n-m+1; i++) {
                for (int j = 0; j < n-m+1; j++) {
                    // n-m번만큼 돌며, 시작위치 값을 찾고
                    // m^2으로 파리채 범위를 더해준다.
                    int sum = 0;
                    for (int k = i; k < i+m; k++) {
                        for (int l = j; l < j + m; l++) {
                            sum += arr[k][l];
                        }
                    }
                    max = Math.max(max, sum);
                }
            }

            System.out.println("#" + testCase + " " + max);
        }
    }
}
