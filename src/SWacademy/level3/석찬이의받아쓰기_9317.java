package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 석찬이의받아쓰기_9317 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            String A = br.readLine();
            String B = br.readLine();

            int count = 0;

            // 길이가 다른 경우는 고려하지 않음.
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) == B.charAt(i)) {
                    count++;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(testCase).append(" ").append(count);
            System.out.println(sb);
        }
    }
}
