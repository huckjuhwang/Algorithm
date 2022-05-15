package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이진수표현 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            String binary = Integer.toBinaryString(m);
            boolean check = true;

            if ( binary.length() < n ) {
                check = false;
            }else {
                int start = binary.length() - n;

                for (int i = start; i < binary.length(); i++) {
                    if (binary.charAt(i) != '1') {
                        check = false;
                        break;
                    }
                }
            }


            if (check) {
                System.out.println("#" + testCase + " " + "ON");
            }else {
                System.out.println("#" + testCase + " " + "OFF");
            }
        }
    }
}
