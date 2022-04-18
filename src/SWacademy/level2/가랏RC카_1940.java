package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가랏RC카_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {

            int n = Integer.parseInt(br.readLine());
            int sum = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                int fastOrSlow = Integer.parseInt(st.nextToken());
                if (fastOrSlow == 0) {
                    continue;
                }
                int val = Integer.parseInt(st.nextToken());

                if (fastOrSlow == 1) {          // 가속
                    sum += val * (n-i);
                } else if (fastOrSlow == 2) {       // 감속
                    sum -= val * (n-i);
                    if (sum < 0) {
                        sum = 0;
                    }
                }
            }
            System.out.println("#" + testCase + " " + sum);

        }
    }
}
