package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 북북서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            String router = br.readLine();
            int n = router.length();

            router = router.replace("north", "N");
            router = router.replace("west", "W");


            int a = 0;
            int idx=0;

            int Anumerator; // 분자
            int Adenominator = 1; // 분모


            int numerator; // 분자
            int denominator; // 분모

            for (int i = n - 2; i >= 0; i--) {
                char ch = router.charAt(i);
                numerator = 90;
                denominator = (int) Math.pow(2, idx);
                if (ch == 'W') {


                } else if (ch == 'E') {

                }

                // 2의 지수승을 표현하기 위한 변수
                idx++;

            }

        }

    }
}
