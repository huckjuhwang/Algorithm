package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calkin_wilfTree_11688 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            String LR = br.readLine();
            int a = 1;
            int b = 1;

            for (int i = 0; i < LR.length(); i++) {
                char ch = LR.charAt(i);
                if (ch == 'L') {
                    b = a + b;
                } else if (ch == 'R') {
                    a = a + b;
                }
            }

            System.out.println("#" + testCase + " " + a + " " + b);
        }

    }
}
