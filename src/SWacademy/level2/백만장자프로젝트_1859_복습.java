package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백만장자프로젝트_1859_복습 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            long money = 0;
            long max = 0;

            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = n - 1; i > 0; i--) {
                max = Math.max(max, arr[i]);
                if (max > arr[i - 1])   money += max - arr[i - 1];
            }


            StringBuilder sb = new StringBuilder();
            sb.append("#").append(testCase).append(" ").append(money);
            System.out.println(sb);
        }
    }
}
