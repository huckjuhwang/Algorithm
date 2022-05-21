package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Summation_8658 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            while (st.hasMoreTokens()) {
                String number = st.nextToken();
                int sum = 0;
                for (int i = 0; i < number.length(); i++) {
                    sum += number.charAt(i) - '0';
                }

                min = Math.min(min, sum);
                max = Math.max(max, sum);
            }

            System.out.println("#" + testCase + " " + max + " " + min);
        }

    }
}
