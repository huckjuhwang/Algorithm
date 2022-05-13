package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홀수피라미드_8016 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int left = (n - 1) * (n - 1) * 2 + 1;
            int right = n * n * 2 - 1;
            System.out.println("#" + testCase + " " + left + " " + right);
        }
    }
}
