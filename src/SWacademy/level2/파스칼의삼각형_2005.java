package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파스칼의삼각형_2005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= test; testCase++) {

            int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[n][n];
            System.out.println("#" + testCase);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i ; j++) {
                    if (i == j || j == 0) {
                        arr[i][j] = 1;
                        continue;
                    }
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] != 0) {
                        System.out.print(arr[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }

    }


}
