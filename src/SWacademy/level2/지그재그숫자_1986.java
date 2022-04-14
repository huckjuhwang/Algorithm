package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 지그재그숫자_1986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= n; testCase++) {
            int a = Integer.parseInt(br.readLine());
            int sum = 1;
            for (int i = 2; i <= a; i++) {
                // 짝수인 경우
                if (i % 2 == 0) {
                    sum -= i;
                }else { // 홀수인 경우
                    sum += i;
                }
            }

            System.out.println("#" + testCase + " " + sum);

        }
    }
}
