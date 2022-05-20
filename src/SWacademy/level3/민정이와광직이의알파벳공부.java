package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 민정이와광직이의알파벳공부 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int alpha[] = new int[26];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < str.length(); j++) {
                    alpha[str.charAt(j) - 'a']++;
                }
            }

            Arrays.sort(alpha);
            System.out.println("#" + testCase + " " + alpha[0]);
        }
    }
}
