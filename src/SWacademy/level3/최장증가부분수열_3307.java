package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최장증가부분수열_3307 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {

            // 문자 개수
            int n = Integer.parseInt(br.readLine());
            // 문자 담은 배열
            int number[] = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < n; i++) {
                number[i] = Integer.parseInt(st.nextToken());
            }

            int beforeP = 0;
            int afterP = 0;
            int count = 1;
            int max = 0;

            for (int i = 0; i < n-1; i++) {
                beforeP = i;
                for (int j = i + 1; j < n; j++) {
                    if (number[beforeP] < number[j]) {
                        System.out.println(number[beforeP]);
                        beforeP = j;
                        count++;
                    }
                }
                if (max < count) {
                    max = count;
                }
                count = 1;
            }
            System.out.println( "#" + testCase + " " + max);
        }

    }
}
