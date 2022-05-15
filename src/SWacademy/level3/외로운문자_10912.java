package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 외로운문자_10912 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            String pair = br.readLine();
            int[] alpha = new int[26];

            for (int i = 0; i < pair.length(); i++) {
                alpha[pair.charAt(i) - 'a']++;
            }


            StringBuilder sb = new StringBuilder();
            sb.append("#").append(testCase).append(" ");

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                // 만약 남는 문자가 있을 경우
                if (alpha[i] % 2 == 1) {
                    result.append((char) (i + 'a'));
                }
            }

            if (result.length() == 0)
                result.append("Good");

            sb.append(result);
            System.out.println(sb);
        }

    }
}
