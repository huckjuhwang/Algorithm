package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주혁이의복권당첨 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); // 당첨복권의 수
            int M = Integer.parseInt(st.nextToken()); // 혁주의 복권 수

            String lotto[] = new String[N];
            int price[] = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                lotto[i] = st.nextToken();
                price[i] = Integer.parseInt(st.nextToken());
            }

            String myNumber[] = new String[M];
            for (int i = 0; i < M; i++) {
                myNumber[i] = br.readLine();
            }


            long sum = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (isSame(lotto[j], myNumber[i])) {
                        sum += price[j];
                        break;
                    }
                }
            }
            System.out.println("#" + testCase + " " + sum);
         }
    }

    public static boolean isSame(String num1, String num2) {
        int n = num1.length();

        for (int i = 0; i < n; i++) {
            if (num1.charAt(i) == '*')   continue;
            if (num1.charAt(i) != num2.charAt(i))     return false;
        }
        return true;
    }
}
