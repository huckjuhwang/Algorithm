package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 22.04.14 개선 완료 ( n^2 -> n )
 * 22.05.26 재 풀이
 */
public class 백만장자프로젝트_1859 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = arr[n-1];
            long sum = 0;
            for (int i = n - 2; i >= 0; i--) {
                if (max < arr[i]) {
                    max = arr[i];
                }else{
                    sum += max - arr[i];
                }
            }
            System.out.println("#" + testCase + " " + sum);
        }

    }
}
