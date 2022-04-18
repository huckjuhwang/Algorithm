package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Fatten_1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 10;
        for (int testCase = 1; testCase <= t; testCase++) {

            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int arr[] = new int[100];

            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            for (int i = 0; i < n; i++) {
                // 덤프
                arr[99] -= 1;
                arr[0] += 1;
                Arrays.sort(arr);
            }
            System.out.println("#" + testCase + " " + (arr[99] - arr[0]));

        }
    }
}
