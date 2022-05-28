package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 달팽이숫자_1954_복습 {
    // 오, 하, 왼, 위
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[n][n];

            int x = 0;
            int y = 0;
            for (int count = 1; count <= n*n;) {
                for (int i = 0; i < 4; i++) {
                    int nx = x;
                    int ny = y;

                    while (true) {
                        // 다음 카운트 값을 넣음
                        arr[nx][ny] = count++;
                        // 현재 count 값이 초과했을 경우
                        if( count > n*n ) break;
                        nx += dx[i];
                        ny += dy[i];
                        // 범위를 벗어낫거나 숫자가 있을 경우
                        if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] != 0)   break;
                    }

                    // nx를 원래대로 돌리고, 다음 회전값으로 옮겨놓음
                    x = nx - dx[i] + dx[(i+1)%4];
                    y = ny - dy[i] + dy[(i+1)%4];

                    // 현재 count 값이 초과했을 경우
                    if( count > n*n ) break;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(testCase);
            System.out.println(sb);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
