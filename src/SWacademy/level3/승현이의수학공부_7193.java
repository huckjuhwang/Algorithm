package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 승현이의수학공부_7193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long N = Integer.parseInt(st.nextToken());

            String number = st.nextToken();
            char ch[] = number.toCharArray();

            long mod = 1;
            long sum = 0;

            for (int i = ch.length-1; i >=0 ; i--) {
                sum += ch[i] - '0';
            }

            System.out.println("#" + testCase + " " + sum % (N-1));
        }
    }
}
