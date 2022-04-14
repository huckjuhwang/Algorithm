package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 중간평균값구하기_1984 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= n; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int numbers[] = new int[st.countTokens()];

            int len = st.countTokens();

            for (int i = 0; i < len; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(numbers);
            int sum = 0;
            for (int i = 1; i < numbers.length - 1; i++) {
                sum += numbers[i];
            }

            System.out.println("#" + testCase + " " + Math.round((float) sum/(numbers.length-2)));
        }
    }
}
