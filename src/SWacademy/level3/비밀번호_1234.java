package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 비밀번호_1234 {

    static String replace[] = {"00", "11", "22", "33", "44", "55", "66", "77", "88", "99"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            String number = st.nextToken();

            boolean tf = true;
            while (tf) {
                tf = false;
                for (int i = 0; i < replace.length; i++) {
                    if (number.contains(replace[i])) {
                        tf = true;
                        number = number.replace(replace[i], "");
                    }
                }
            }
            System.out.println("#" + testCase + " " + number);

        }
    }
}
