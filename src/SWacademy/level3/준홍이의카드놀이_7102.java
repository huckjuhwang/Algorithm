package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 준홍이의카드놀이_7102 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int arr[] = new int[41];

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    arr[i+j]++;
                }
            }

            int max = 0;
            for (int i = 0; i < arr.length; i++)
                max = Math.max(max, arr[i]);



            System.out.print("#" + testCase + " ");
            for (int i = 0; i < arr.length; i++) {
                if (max == arr[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }
}
