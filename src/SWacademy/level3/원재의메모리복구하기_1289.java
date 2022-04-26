package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 원재의메모리복구하기_1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {

            String num = br.readLine();

            boolean zero = true;
            boolean one = false;
            int cnt = 0;
            
            for (int i = 0; i < num.length(); i++) {
                char ch = num.charAt(i);
                if (ch == '1' && zero) {
                    cnt ++;
                    zero = false;
                    one = true;
                } else if (ch == '0' && one) {
                    cnt ++;
                    zero = true;
                    one = false;
                }
            }

            System.out.println("#" + testCase + " " + cnt);

        }
    }
}
