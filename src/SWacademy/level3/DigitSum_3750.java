package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitSum_3750 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            long n = Long.parseLong(br.readLine());
            long sum = n;

            do {
                sum = 0;
                while (n != 0) {
                    sum += n % 10;
                    n /= 10;
                }
                n = sum;
            } while (sum >= 10);

            System.out.println("#" + testCase + " " + sum);
        }
    }
}
