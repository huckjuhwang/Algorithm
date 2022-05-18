package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1/5..
 */
public class 제곱팰링드롬수_10570 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            int count = 0;

            for (int i = from; i <= to; i++) {
                // 팰린드롬이면,
                if (isPalindrome(Integer.toString(i))) {
                    // 제곱근이 실수형이 아니라면서, 팰린드롬이라면 ++
                    double sqrt = Math.sqrt(i);
                    if (i % sqrt == 0) {
                        if (isPalindrome(Integer.toString((int)sqrt))) {
                            count++;
                        }
                    }
                }
            }

            System.out.println("#" + testCase + " " + count);
        }

    }

    public static boolean isPalindrome(String number) {
        return number.equals(reverseString(number));
    }

    public static String reverseString(String number) {
        return new StringBuilder(number).reverse().toString();
    }
}
