package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 성공적인공연기획_4789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            String num = br.readLine();

            int count = num.charAt(0) - '0';
            int answer = 0;
            for (int i = 1; i < num.length(); i++) {
                if (count < i) {
                    count++;
                    answer++;
                }

                count += num.charAt(i) - '0';
            }

            System.out.println("#" + testCase + " " + answer);
        }
    }
}
