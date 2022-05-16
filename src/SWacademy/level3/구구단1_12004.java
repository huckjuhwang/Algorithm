package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 구구단1_12004 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int num = Integer.parseInt(br.readLine());

            boolean check = false;

            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    if (i * j == num) {
                        check = true;
                    }
                }
            }

            if (check) {
                System.out.println("#" + testCase + " " + "Yes");
            }else{
                System.out.println("#" + testCase + " " + "No");
            }
        }
    }
}
