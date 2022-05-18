package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 무한사전_11445 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            String P = br.readLine();
            String Q = br.readLine();

            if ((!Q.equals(P + "a"))) {
                System.out.println("#" + testCase + " " + "Y");
            }else{
                System.out.println("#" + testCase + " " + "N");
            }
        }
    }
}
