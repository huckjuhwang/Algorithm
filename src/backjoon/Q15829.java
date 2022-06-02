package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15829 {

    static int M = 1234567891;
    static int r = 31;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        String number = br.readLine();
        long sum = 0;
        long pow = 1;

        for (int i = 0; i < n; i++) {
            sum += ((number.charAt(i) - 'a') + 1) * pow % M;
            pow = (pow*r) % M;
        }

        System.out.println(sum % M);
    }
}
