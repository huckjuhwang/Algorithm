package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문제제목붙이기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int alpha[] = new int[26];
            int n = Integer.parseInt(br.readLine());
            int count = 26;

            for (int i = 0; i < n; i++)
                alpha[br.readLine().charAt(0) - 'A']++;

            for (int i = 0; i < alpha.length; i++) {
                if (alpha[i] == 0) {
                    count = i;
                    break;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(testCase).append(" ").append(count);

            System.out.println(sb);



        }
    }
}
