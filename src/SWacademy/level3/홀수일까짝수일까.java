package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홀수일까짝수일까 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            String n = br.readLine();
            int num = n.charAt(n.length() - 1) - '0';
            if (num % 2 == 0) {
                System.out.println("#" + testCase + " " + "Even");
            }else{
                System.out.println("#" + testCase + " " + "Odd");
            }
        }
    }
}
