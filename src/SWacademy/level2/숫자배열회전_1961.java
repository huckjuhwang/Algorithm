package SWacademy.level2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 숫자배열회전_1961 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int n = Integer.parseInt(br.readLine());
            String result[][] = new String[n][3];
            String arr[][] = new String[n][n];

            // input
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine().split(" ");
            }

            // 90도 계산
            String numbers = "";
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    numbers += arr[j][i];
                }
                result[i][0] = numbers;
                numbers = "";
            }


            // 180도 계산
            numbers = "";
            int i_idx = 0;
            for (int i = n-1; i >=0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    numbers += arr[i][j];
                }
                result[i_idx++][1] = numbers;
                numbers = "";
            }


            // 270도 계산
            numbers = "";
            i_idx = 0;
            for (int i = n-1; i >=0; i--) {
                for (int j = 0; j < n; j++) {
                    numbers += arr[j][i];
                }
                result[i_idx++][2] = numbers;
                numbers = "";
            }

            System.out.println("#" + testCase);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }

        }
    }

}

