package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 미니멀리즘시계_9997 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {

            int n = Integer.parseInt(br.readLine());
            int hour = n / 30;

            n %= 30;
            int minute = n*2;

            System.out.println("#" + testCase + " " + hour + " " + minute);
        }
    }
}
