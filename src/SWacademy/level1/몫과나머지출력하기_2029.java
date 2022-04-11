package SWacademy.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 몫과나머지출력하기_2029 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str[] = br.readLine().split(" ");

            int quotient = Integer.parseInt(str[0]) / Integer.parseInt(str[1]);
            int remainder = Integer.parseInt(str[0]) % Integer.parseInt(str[1]);
            System.out.println("#" + (i + 1) + " " + quotient + " " + remainder);

        }
    }

}
