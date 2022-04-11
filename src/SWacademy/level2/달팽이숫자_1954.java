package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 달팽이숫자_1954 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());


        for (int a = 0; a < num; a++) {

            int n = Integer.parseInt(br.readLine());
            int grid[][] = new int[n][n];

            int i =0;
            int j =0;
            int count = 1;

            int m = n;

            for (int k = 0; k < m; k++) {
                grid[i][j++] = count++;
            }
            i++;  j--; m--;

            while (m != 0) {

                // 아래쪽이동
                for (int k = 0; k < m; k++) {
                    grid[i++][j] = count++;
                }
                i--; j--;

                // 왼쪽이동
                for (int k = 0; k < m; k++) {
                    grid[i][j--] = count++;
                }
                j++;  i--;

                if (--m == 0) {
                    break;
                }

                // 위쪽이동
                for (int k = 0; k < m; k++) {
                    grid[i--][j] = count++;
                }
                i++; j++;

                // 오른쪽 이동
                for (int k = 0; k < m; k++) {
                    grid[i][j++] = count++;
                }
                j--; i++; m--;
            }

            System.out.println("#" + (a+1));
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                System.out.print( grid[k][l] + " " );
            }
            System.out.println();
        }

        }

    }
}
