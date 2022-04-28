package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 민석이의_과제_체크하기_5431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            int number[] = new int[N + 1];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < a; i++) {
                number[Integer.parseInt(st.nextToken())] = 1;
            }

            System.out.print("#" + testCase + " ");
            for (int i = 1; i <= N; i++) {
                if (number[i] == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }
}
