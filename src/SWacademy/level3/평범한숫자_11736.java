package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한숫자_11736 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int arr[] = new int[n];
            int count = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < n - 1; i++) {
                int max = Math.max(arr[i - 1], Math.max(arr[i], arr[i + 1]));
                int min = Math.min(arr[i - 1], Math.min(arr[i], arr[i + 1]));

                if (min != arr[i] && max != arr[i]) {
                    count++;
                }
            }
            System.out.println( "#" + testCase + " "  +count);
        }
    }
}
