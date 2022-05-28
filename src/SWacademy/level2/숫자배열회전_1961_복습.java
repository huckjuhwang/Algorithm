package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자배열회전_1961_복습 {

    static int n;
    static String result[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            n = Integer.parseInt(br.readLine());
            int arr[][] = new int[n][n];
            result = new String[n][3];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < 3 ; i++) {
                arr = swapArr(arr, n);   // 90도 배열 회전
                setResult(arr, i);       // i번째 열에 세팅
            }

            resultPrint(testCase);
        }

    }

    private static void resultPrint(int testCase) {
        System.out.println("#" + testCase);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void setResult(int[][] temp, int range) {
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(temp[i][j]);
            }
            result[i][range] = sb.toString();
        }
    }

    public static int[][] swapArr(int arr[][], int n){

        int temp[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = arr[n - j-1][i];
            }
        }
        return temp;
    }
}
