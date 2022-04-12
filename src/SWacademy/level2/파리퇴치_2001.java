package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파리퇴치_2001 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++) {

            // 최댓 값 구하기
            int max = 0;

            String temp[] = br.readLine().split(" ");
            // n*n의 배열크기
            int n = Integer.parseInt(temp[0]);
            // m*m의 파리채
            int m = Integer.parseInt(temp[1]);
            int numbers[][] = new int[n][n];

            // input
            for (int j = 0; j < n; j++) {
                String grid[] = br.readLine().split(" ");

                for (int k = 0; k < grid.length; k++) {
                    numbers[j][k] = Integer.parseInt( grid[k] );
                }
            }

            int now = 0;

            for (int j = 0; j <= n - m; j++) {
                for (int k = 0; k <= n - m; k++) {
                    // 현재 위치 기준 m*m
                    for (int l = j; l < j+m; l++) {
                        for (int o = k; o < k +m; o++) {
                            now += numbers[l][o];
                        }
                    }

                     if (now > max) {
                        max = now;
                    }
                     now = 0;
                }
            }

            System.out.print("#" + (i + 1) + " " + max);
        }

    }
}
