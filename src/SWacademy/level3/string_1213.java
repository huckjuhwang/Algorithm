package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class string_1213 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;
        for (int testCase = 1; testCase <= t; testCase++) {
            br.readLine();
            String word = br.readLine();
            String str = br.readLine();

//            System.out.println(str.replace(word, "!"));
            str = str.replace(word, "!");
            int cnt = 0;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '!') {
                    cnt++;
                }
            }
            System.out.println("#" + testCase + " " + cnt);
        }
    }
}
