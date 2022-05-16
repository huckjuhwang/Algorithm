package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 극장좌석_8500 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int sum = 0;
            int max = 0;

            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                sum += num;
                if (num > max)   max = num;
            }

            System.out.println("#" + testCase + " " + (max + sum + n));
        }
    }
}
