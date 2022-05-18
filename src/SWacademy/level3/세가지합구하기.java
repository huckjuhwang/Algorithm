package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세가지합구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            long n = Integer.parseInt(br.readLine());
            long s = n * (n + 1);
            System.out.println("#" + testCase + " " + (s / 2) + " " + (s - n) + " " + s);
        }
    }
}
