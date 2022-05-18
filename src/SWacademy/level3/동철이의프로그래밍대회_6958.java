package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동철이의프로그래밍대회_6958 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int num[] = new int[N];

            int max = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    num[i] += Integer.parseInt(st.nextToken());
                }
                max = Math.max(max, num[i]);
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                if (max == num[i])    count++;
            }

            System.out.println("#" + testCase + " " + count + " " + max);
        }
    }
}
