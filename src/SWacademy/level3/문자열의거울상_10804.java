package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열의거울상_10804 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            String str = br.readLine();

            str = str.replace('b', '1');
            str = str.replace('d', '2');
            str = str.replace('p', '3');
            str = str.replace('q', '4');

            String reverse = new StringBuilder(str).reverse().toString();
            reverse =reverse.replace('2', 'b');
            reverse =reverse.replace('1', 'd');
            reverse =reverse.replace('4', 'p');
            reverse =reverse.replace('3', 'q');

            System.out.println("#" + testCase + " " + reverse);
        }
    }
}
